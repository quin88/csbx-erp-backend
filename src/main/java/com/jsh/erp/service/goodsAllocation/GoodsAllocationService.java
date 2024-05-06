package com.jsh.erp.service.goodsAllocation;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.constants.ExceptionConstants;
import com.jsh.erp.datasource.entities.*;
import com.jsh.erp.datasource.entities.GoodsAllocation;
import com.jsh.erp.datasource.mappers.*;
import com.jsh.erp.datasource.vo.GoodsAllocationVo;
import com.jsh.erp.exception.BusinessRunTimeException;
import com.jsh.erp.exception.JshException;
import com.jsh.erp.service.log.LogService;
import com.jsh.erp.service.user.UserService;
import com.jsh.erp.utils.BaseResponseInfo;
import com.jsh.erp.utils.ExcelUtils;
import com.jsh.erp.utils.StringUtil;
import jxl.Sheet;
import jxl.Workbook;
import liquibase.pro.packaged.G;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Service
public class GoodsAllocationService {
    private Logger logger = LoggerFactory.getLogger(GoodsAllocationService.class);

    @Resource
    private UserService userService;
    @Resource
    private LogService logService;
    @Resource
    private GoodsAllocationMapper goodsAllocationMapper;
    @Resource
    private GoodsAllocationMapperEx goodsAllocationMapperEx;
    @Resource
    private DepotMapperEx depotMapperEx;

    public List<GoodsAllocationVo> select(Long depotId, Long smallDepotId, String number, String capacityStatus, String enabled,
                                          int offset, int rows) throws Exception {
        List<GoodsAllocationVo> list = null;
        try {
            list = goodsAllocationMapperEx.selectByConditionGoodsAllocation(depotId, smallDepotId, number, capacityStatus, enabled, offset, rows);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    public Long counts(Long depotId, Long smallDepotId, String number, String capacityStatus, String enabled) {
        Long result = null;
        try {
            result = goodsAllocationMapperEx.countsByGoodsAllocation(depotId, smallDepotId, number, capacityStatus, enabled);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }


    public int checkIsNameExist(Long id, String name) throws Exception {
        GoodsAllocationExample example = new GoodsAllocationExample();
        example.createCriteria().andIdNotEqualTo(id).andGoodsAllocationEqualTo(name).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<GoodsAllocation> list = null;
        try {
            list = goodsAllocationMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list == null ? 0 : list.size();
    }


    public Object getGoodsAllocation(Long id) {
        GoodsAllocation result = null;
        try {
            result = goodsAllocationMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int insert(JSONObject obj, HttpServletRequest request) throws Exception {
        GoodsAllocation goodsAllocation = JSONObject.parseObject(obj.toJSONString(), GoodsAllocation.class);
        int result = 0;
        Long userId = userService.getCurrentUser().getId();
        try {
            //检查编号是否重复
            GoodsAllocationExample example = new GoodsAllocationExample();
            example.createCriteria().andNumberEqualTo(goodsAllocation.getNumber()).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
            List<GoodsAllocation> list = goodsAllocationMapper.selectByExample(example);
            if (list.size() > 0) {
                throw new BusinessRunTimeException(ExceptionConstants.GOODS_ALLOCATION_NUMBER_REPETITION_OVER_CODE,
                        String.format(ExceptionConstants.GOODS_ALLOCATION_NUMBER_REPETITION_OVER_MSG));
            }
            Date date = new Date();
            goodsAllocation.setEnabled(false);//默认不启用
            goodsAllocation.setCreator(userId);
            goodsAllocation.setCreateTime(date);
            goodsAllocation.setUpdater(userId);
            goodsAllocation.setUpdateTime(date);
            result = goodsAllocationMapper.insertSelective(goodsAllocation);
            logService.insertLog("货位管理",
                    new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_ADD).append(goodsAllocation.getGoodsAllocation()).toString(), request);

        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int update(JSONObject obj, HttpServletRequest request) throws Exception {
        Long userId = userService.getCurrentUser().getId();
        GoodsAllocation goodsAllocation = JSONObject.parseObject(obj.toJSONString(), GoodsAllocation.class);
        int result = 0;
        try {
            //检查编号是否重复
            GoodsAllocationExample example = new GoodsAllocationExample();
            example.createCriteria().andNumberEqualTo(goodsAllocation.getNumber()).
                    andIdNotEqualTo(goodsAllocation.getId()).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
            List<GoodsAllocation> list = goodsAllocationMapper.selectByExample(example);
            if (list.size() > 0) {
                throw new BusinessRunTimeException(ExceptionConstants.GOODS_ALLOCATION_NUMBER_REPETITION_OVER_CODE,
                        String.format(ExceptionConstants.GOODS_ALLOCATION_NUMBER_REPETITION_OVER_MSG));
            }
            goodsAllocation.setUpdater(userId);
            goodsAllocation.setUpdateTime(new Date());
            result = goodsAllocationMapper.updateByPrimaryKeySelective(goodsAllocation);
            logService.insertLog("货位管理",
                    new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_ADD).append(goodsAllocation.getGoodsAllocation()).toString(), request);

        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int delete(Long id, HttpServletRequest request) throws Exception {
        return batchDeleteGoodsAllocationByIds(id.toString());
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDelete(String ids, HttpServletRequest request) throws Exception {
        return batchDeleteGoodsAllocationByIds(ids);
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteGoodsAllocationByIds(String ids) throws Exception {
        String[] idArray = ids.split(",");
        User userInfo = userService.getCurrentUser();
        //只有禁用的数据可以删除
        Long res = goodsAllocationMapperEx.countIsActive(idArray);//查询这些数据中是否有启用的账户
        if (res > 0) {
            throw new BusinessRunTimeException(ExceptionConstants.DELETE_ACTIVE_GOODS_ALLOCATION_FAILED_CODE,
                    String.format(ExceptionConstants.DELETE_ACTIVE_GOODS_ALLOCATION_FAILED_MSG));
        }
        int result = 0;
        try {
            result = goodsAllocationMapperEx.batchDeleteGoodsAllocationByIds(new Date(), userInfo == null ? null : userInfo.getId(), idArray);
            //记录日志
            StringBuffer sb = new StringBuffer();
            sb.append(BusinessConstants.LOG_OPERATION_TYPE_DELETE);
            logService.insertLog("货位管理", sb.toString(),
                    ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    private List<GoodsAllocation> getGoodsAllocationByIds(String ids) {
        List<Long> idList = StringUtil.strToLongList(ids);
        List<GoodsAllocation> list = new ArrayList<>();
        try {
            GoodsAllocationExample example = new GoodsAllocationExample();
            example.createCriteria().andIdIn(idList);
            list = goodsAllocationMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchSetActive(Boolean enabled, String ids) throws Exception {
        User userInfo = userService.getCurrentUser();

        int result = 0;
        List<Long> seIds = new ArrayList<>();
        List<Long> gaIds = StringUtil.strToLongList(ids);
        for (Long id : gaIds) {
            GoodsAllocation goodsAllocation = goodsAllocationMapper.selectByPrimaryKey(id);
            if (enabled) {//启用
                if (!goodsAllocation.getEnabled()) {
                    seIds.add(id);
                } else {
                    throw new BusinessRunTimeException(ExceptionConstants.GOODS_ALLOCATION_UPDATE_ACTIVE_TURE_FAILED_CODE, String.format(ExceptionConstants.GOODS_ALLOCATION_UPDATE_ACTIVE_TURE_FAILED_MSG));
                }
            } else {//改为禁用
                if (goodsAllocation.getEnabled()) {
                    seIds.add(id);
                } else {
                    throw new BusinessRunTimeException(ExceptionConstants.GOODS_ALLOCATION_UPDATE_ACTIVE_FALSE_FAILED_CODE, String.format(ExceptionConstants.GOODS_ALLOCATION_UPDATE_ACTIVE_FALSE_FAILED_MSG));
                }
            }
        }
        if (seIds.size() > 0) {
            GoodsAllocation goodsAllocation = new GoodsAllocation();
            goodsAllocation.setEnabled(enabled);
            goodsAllocation.setUpdater(userInfo == null ? null : userInfo.getId());
            goodsAllocation.setUpdateTime(new Date());
            GoodsAllocationExample example = new GoodsAllocationExample();
            example.createCriteria().andIdIn(seIds);
            result = goodsAllocationMapper.updateByExampleSelective(goodsAllocation, example);
        }
        logService.insertLog("货位管理",
                new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_ENABLED).toString(),
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        return result;
    }

    public BaseResponseInfo importExcel(MultipartFile file, HttpServletRequest request) {
        BaseResponseInfo info = new BaseResponseInfo();
        try {
            //文件扩展名只能为xls
            String fileName = file.getOriginalFilename();
            if (StringUtil.isNotEmpty(fileName)) {
                String fileExt = fileName.substring(fileName.indexOf(".") + 1);
                if (!("xls".equals(fileExt) || "xlsx".equals(fileExt))) {
                    throw new BusinessRunTimeException(ExceptionConstants.MATERIAL_EXTENSION_ERROR_CODE,
                            ExceptionConstants.MATERIAL_EXTENSION_ERROR_MSG);
                }
            }
            Workbook workbook = Workbook.getWorkbook(file.getInputStream());
            Sheet src = workbook.getSheet(0);
            //获取真实的行数，剔除掉空白行
            int rightRows = ExcelUtils.getRightRows(src);
            List<GoodsAllocation> goodsList = new ArrayList<>();
            Set<String> depotGoodsSet = new HashSet<>();
            for (int i = 2; i < rightRows; i++) {

                String depot = ExcelUtils.getContent(src, i, 0); //仓库
                String goodsAllocation = ExcelUtils.getContent(src, i, 1); //货位
                String remark = ExcelUtils.getContent(src, i, 2); //备注
                String active = ExcelUtils.getContent(src, i, 3); //状态

                GoodsAllocation goods = new GoodsAllocation();
                //根据仓库名称查询仓库id
                Long depotId = depotMapperEx.selectDepotIdByDepot(depot);
                if (depotId == null) {
                    throw new BusinessRunTimeException(ExceptionConstants.DEPOT_IS_EMPTY_OVER_CODE,
                            String.format(ExceptionConstants.DEPOT_IS_EMPTY_OVER_MSG, i + 1));
                }
                //仓库名称长度超出
                if (depot.length() > 20) {
                    throw new BusinessRunTimeException(ExceptionConstants.DEPOT_NAME_OVER_CODE,
                            String.format(ExceptionConstants.DEPOT_NAME_OVER_MSG, i + 1));
                }
                //货位为空
                if (StringUtil.isEmpty(goodsAllocation)) {
                    throw new BusinessRunTimeException(ExceptionConstants.GOODS_ALLOCATION_IS_EMPTY_OVER_CODE,
                            String.format(ExceptionConstants.GOODS_ALLOCATION_IS_EMPTY_OVER_MSG, i + 1));
                }
                //货位长度超出
                if (goodsAllocation.length() > 50) {
                    throw new BusinessRunTimeException(ExceptionConstants.GOODS_ALLOCATION_NAME_OVER_CODE,
                            String.format(ExceptionConstants.GOODS_ALLOCATION_NAME_OVER_MSG, i + 1));
                }
                //检查启用状态
                if ("0".equals(active)) {//禁用
                    goods.setEnabled(false);
                } else if ("1".equals(active)) {//启用
                    goods.setEnabled(true);
                } else {
                    throw new BusinessRunTimeException(ExceptionConstants.GOODS_ALLOCATION_NAME_OVER_CODE,
                            String.format(ExceptionConstants.GOODS_ALLOCATION_NAME_OVER_MSG, i + 1));
                }

                // 检查在相同的仓库情况下是否有相同的货位
                String depotGoodsKey = depot + "-" + goodsAllocation;
                if (depotGoodsSet.contains(depotGoodsKey)) {
                    throw new BusinessRunTimeException(ExceptionConstants.EXCEL_GOODS_ALLOCATION_NAME_REPETITION_OVER_CODE,
                            String.format(ExceptionConstants.EXCEL_GOODS_ALLOCATION_NAME_REPETITION_OVER_MSG, i + 1));
                } else {
                    depotGoodsSet.add(depotGoodsKey);
                }

                goods.setGoodsAllocation(goodsAllocation);
                goods.setDepot(depot);
                goods.setDepotId(depotId);
                goods.setRemark(remark);
                goods.setCreator(userService.getCurrentUser().getId());
                goods.setCreateTime(new Date());
                goodsList.add(goods);
            }
            for (GoodsAllocation goodsAllocation : goodsList) {
                goodsAllocationMapper.insertSelective(goodsAllocation);
            }
            logService.insertLog("货位管理",
                    new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_IMPORT).append(goodsList.size()).append(BusinessConstants.LOG_DATA_UNIT).toString(),
                    ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
            info.code = 200;
            info.data = "导入成功";
        } catch (BusinessRunTimeException e) {
            info.code = e.getCode();
            info.data = e.getData().get("message");
        } catch (Exception e) {
            e.printStackTrace();
            info.code = 500;
            info.data = "导入失败";
        }
        return info;
    }

    public List<GoodsAllocation> findBySelect(Long depotId, boolean active) {
        GoodsAllocationExample example = new GoodsAllocationExample();
        example.createCriteria().andDepotIdEqualTo(depotId).andEnabledEqualTo(active)
                .andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        example.setOrderByClause("id desc");
        List<GoodsAllocation> list = null;
        try {
            list = goodsAllocationMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }


}


