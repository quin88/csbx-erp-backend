package com.jsh.erp.service.opinion;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.datasource.dto.OpinionDTO;
import com.jsh.erp.datasource.entities.ImageInfo;
import com.jsh.erp.datasource.entities.Opinion;
import com.jsh.erp.datasource.entities.User;
import com.jsh.erp.datasource.mappers.ImageInfoMapper;
import com.jsh.erp.datasource.mappers.OpinionMapper;
import com.jsh.erp.datasource.mappers.OpinionMapperEx;
import com.jsh.erp.exception.JshException;
import com.jsh.erp.service.imageInfo.ImageInfoService;
import com.jsh.erp.service.log.LogService;
import com.jsh.erp.service.supermarketServeClient.SupermarketServeClientService;
import com.jsh.erp.service.user.UserService;
import com.jsh.erp.utils.SendDingDingUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class OpinionService {
    private Logger logger = LoggerFactory.getLogger(SupermarketServeClientService.class);

    @Resource
    private OpinionMapper opinionMapper;
    @Resource
    private UserService userService;
    @Resource
    private LogService logService;
    @Resource
    private OpinionMapperEx opinionMapperEx;
    @Resource
    private ImageInfoMapper imageInfoMapper;
    @Resource
    private SendDingDingUtils sendDingDingUtils;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int insert(JSONObject obj, HttpServletRequest request) throws Exception {
        Opinion opinion = JSONObject.parseObject(obj.toJSONString(), Opinion.class);
        int result = 0;
        User userInfo = userService.getCurrentUser();
        try {
            result = opinionMapper.insertSelective(opinion);
            logService.insertLog("意见",
                    new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_ADD).append(opinion.getId()).toString(), request);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    /**
     * 保存意见表详情
     *
     * @param opinionDTO
     * @param request
     * @return
     * @throws Exception
     */
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public Object saveOpinionDetail(OpinionDTO opinionDTO, HttpServletRequest request) throws Exception {
        Opinion opinion = opinionDTO.getOpinion();
        User userInfo = userService.getCurrentUser();
        int result = 0;
        try {
            opinionMapperEx.insertOpinionSelective(opinion);
            Long id = opinion.getId();//获取意见表id
            List<ImageInfo> imageInfos = opinionDTO.getImageInfos();
            if (imageInfos != null) {
                for (ImageInfo imageInfo : imageInfos) {
                    imageInfo.setOpinionId(id);
                    imageInfoMapper.insertSelective(imageInfo);
                }
            }
            //发钉钉通知，等待PC端完成放开
           /* String content = "你有一项来自小程序的审核请求，审核项目为：出入库申请审核，请尽快进行审核，点击：" + depot_head_check_link;
            sendDingDingUtils.sendDingDingUtils(content);*/
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }
}
