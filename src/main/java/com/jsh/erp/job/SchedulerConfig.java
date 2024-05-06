package com.jsh.erp.job;

import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.datasource.entities.PriceDetails;
import com.jsh.erp.datasource.entities.PriceDetailsExample;
import com.jsh.erp.datasource.entities.PriceReceipts;
import com.jsh.erp.datasource.entities.PriceReceiptsExample;
import com.jsh.erp.datasource.mappers.PriceDetailsMapper;
import com.jsh.erp.datasource.mappers.PriceReceiptsMapper;
import com.jsh.erp.datasource.mappers.SupermarketFinanceMapperEx;
import com.jsh.erp.datasource.vo.SupermarketFinanceVo;
import com.jsh.erp.exception.JshException;
import com.jsh.erp.service.sequence.SequenceService;
import com.jsh.erp.utils.SendDingDingUtils;
import com.jsh.erp.utils.Tools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Configuration
@Profile("!disableQuartz")
@EnableScheduling
public class SchedulerConfig {
    private final Logger logger = LoggerFactory.getLogger(SchedulerConfig.class);

    @Resource
    private PriceDetailsMapper priceDetailsMapper;
    @Resource
    private PriceReceiptsMapper priceReceiptsMapper;
    @Resource
    private SequenceService sequenceService;
    private static Date datetime;
    @Value("${SUPERMARKET.FINANCE.LINK}")
    private String supermarketFinanceLink;
    @Resource
    private SendDingDingUtils sendDingDingUtils;
    @Resource
    private SupermarketFinanceMapperEx supermarketFinanceMapperEx;

    /**
     * 定时任务一：财务管理--每日存储费用：生成费用单据信息
     */
    @Async
    @Scheduled(cron = "0 0 0 * * ?")//每天0点执行
    public void taskForSavePriceReceipts() {
        datetime = new Date();
        try {
            //获取昨天的时间
            String yesterdayBegin = Tools.getYesterday() + BusinessConstants.DAY_FIRST_TIME;
            String yesterdayEnd = Tools.getYesterday() + BusinessConstants.DAY_LAST_TIME;
            //类型转换
            Date yesterdayBeginDate = Tools.parse(yesterdayBegin, "yyyy-MM-dd HH:mm:ss");
            Date yesterdayEndDate = Tools.parse(yesterdayEnd, "yyyy-MM-dd HH:mm:ss");
            PriceReceiptsExample example = new PriceReceiptsExample();
            example.createCriteria().andStatusEqualTo(BusinessConstants.BILLS_STATUS_AUDIT)
                    .andCreateTimeBetween(yesterdayBeginDate, yesterdayEndDate)
                    .andPriceTypeEqualTo("每日存储费用")
                    .andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
            List<PriceReceipts> list = priceReceiptsMapper.selectByExample(example);
            System.out.println("list = " + list);
            for (PriceReceipts receipts : list) {
                savePriceReceiptsAndPriceDetails(receipts);
            }
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
    }

    /**
     * 生成费用单据信息
     *
     * @param receipts
     * @throws Exception
     */
    private void savePriceReceiptsAndPriceDetails(PriceReceipts receipts) throws Exception {
        PriceReceipts item = new PriceReceipts();
        BeanUtils.copyProperties(receipts, item);
        String onlyNumber = sequenceService.buildOnlyNumber();
        onlyNumber = "ZC" + onlyNumber;
        item.setId(null);
        item.setCreateTime(datetime);
        item.setUpdateTime(datetime);
        item.setReceiptsNumber(onlyNumber);
        item.setStatus(BusinessConstants.BILLS_STATUS_UN_AUDIT);
        priceReceiptsMapper.insertSelective(item);
        PriceDetailsExample example = new PriceDetailsExample();
        example.createCriteria().andReceiptsNumberEqualTo(receipts.getReceiptsNumber())
                .andStatusEqualTo(BusinessConstants.BILLS_STATUS_AUDIT)
                .andDeleteFlagNotEqualTo(BusinessConstants.BILLS_STATUS_AUDIT);
        List<PriceDetails> details = priceDetailsMapper.selectByExample(example);
        for (PriceDetails detail : details) {
            PriceDetails priceDetails = new PriceDetails();
            BeanUtils.copyProperties(detail, priceDetails);
            priceDetails.setId(null);
            priceDetails.setCreateTime(datetime);
            priceDetails.setUpdateTime(datetime);
            priceDetails.setReceiptsNumber(onlyNumber);
            priceDetails.setStatus(BusinessConstants.BILLS_STATUS_UN_AUDIT);
            priceDetailsMapper.insertSelective(priceDetails);
        }
    }

    /**
     * 定时任务二：检测是否为最后付款日，如果是则通知
     */
    @Async
    @Scheduled(cron = "0 0 1 * * ?")//每天9点执行，这里是因为时区的原因
    public void taskForPayLastDay() {
        try {
            // 获取当前日期
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime startOfDay = now.toLocalDate().atStartOfDay();
            LocalDateTime endOfDay = now.toLocalDate().atTime(23, 59, 59);

            Date startDate = Date.from(startOfDay.atZone(ZoneId.systemDefault()).toInstant());
            Date endDate = Date.from(endOfDay.atZone(ZoneId.systemDefault()).toInstant());
            List<SupermarketFinanceVo> list = supermarketFinanceMapperEx.selectSupermarketFinanceByPayDate(startDate, endDate);
            for (SupermarketFinanceVo sf : list) {
                if (!BusinessConstants.SUPERMARKET_FINANCE_PAY_STATUS_AUDIT.equals(sf.getPayStatus())) {
                    BigDecimal price = sf.getPriceTotal().setScale(2, RoundingMode.HALF_UP);   // 进行四舍五入并保留两位小数

                    // 如果有付款日期是今天，则发送消息
                    String content = "付款提示\n" +
                            "今日为最后付款日\n" +
                            "单据编号：" + sf.getNumber() + "\n" +
                            "品类：" + sf.getAquaticType() + "\n" +
                            "市场：" + sf.getMarket() + "\n" +
                            "金额：" + price + "\n" +
                            "操作人：" + sf.getCreatedName() + "\n" +
                            "链接：" + supermarketFinanceLink;
                    sendDingDingUtils.sendDingDingUtils(content, null);
                }
            }
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
    }
}

