package com.jsh.erp.service.supermarketReconciliationExtend;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.datasource.entities.*;
import com.jsh.erp.datasource.mappers.SupermarketReconciliationExtendMapper;
import com.jsh.erp.exception.JshException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

@Service
public class SupermarketReconciliationExtendService {
    private Logger logger = LoggerFactory.getLogger(SupermarketReconciliationExtendService.class);
    @Resource
    private SupermarketReconciliationExtendMapper supermarketReconciliationExtendMapper;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public void saveReconciliationExtend(String rows, Long srId, String formula, HttpServletRequest request) throws Exception {
        //删除单据的明细
        deleteReconciliationExtend(srId);

        JSONArray rowArr = JSONArray.parseArray(rows);
        if (null != rowArr && rowArr.size() > 0) {
            for (int i = 0; i < rowArr.size(); i++) {
                SupermarketReconciliationExtend sfe = new SupermarketReconciliationExtend();
                BigDecimal billingPrice = BigDecimal.ZERO;
                BigDecimal systemPrice = BigDecimal.ZERO;

                JSONObject tempInsertedJson = JSONObject.parseObject(rowArr.getString(i));
                sfe.setSupermarketReconciliationId(srId);
                if (tempInsertedJson.get("name") != null && !tempInsertedJson.get("name").equals("")) {
                    sfe.setName(tempInsertedJson.getString("name"));
                }
                if (tempInsertedJson.get("aquaticType") != null && !tempInsertedJson.get("aquaticType").equals("")) {
                    sfe.setAquaticType(tempInsertedJson.getString("aquaticType"));
                }
                if (tempInsertedJson.get("supplyingZeroNumber") != null && !tempInsertedJson.get("supplyingZeroNumber").equals("")) {
                    sfe.setSupplyingZeroNumber(tempInsertedJson.getString("supplyingZeroNumber"));
                }
                if (tempInsertedJson.get("unit") != null && !tempInsertedJson.get("unit").equals("")) {
                    sfe.setUnit(tempInsertedJson.getString("unit"));
                }
                if (tempInsertedJson.get("quantity") != null && !tempInsertedJson.get("quantity").equals("")) {
                    sfe.setQuantity(tempInsertedJson.getBigDecimal("quantity"));
                }
                if (tempInsertedJson.get("billingPrice") != null && !tempInsertedJson.get("billingPrice").equals("")) {
                    billingPrice = tempInsertedJson.getBigDecimal("billingPrice");
                    sfe.setBillingPrice(billingPrice);
                }
                if (tempInsertedJson.get("systemPrice") != null && !tempInsertedJson.get("systemPrice").equals("")) {
                    systemPrice = tempInsertedJson.getBigDecimal("systemPrice");
                    sfe.setSystemPrice(systemPrice);
                }
                //计算公式
                BigDecimal calculate = calculate(formula, systemPrice, billingPrice);
                BigDecimal roundedValue = calculate.setScale(2, RoundingMode.HALF_UP); // 保留两位小数，采用四舍五入方式
                sfe.setPrice(roundedValue);
                supermarketReconciliationExtendMapper.insertSelective(sfe);
            }
        }
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public void deleteReconciliationExtend(Long srId) throws Exception {
        SupermarketReconciliationExtendExample example = new SupermarketReconciliationExtendExample();
        example.createCriteria().andSupermarketReconciliationIdEqualTo(srId);
        try {
            supermarketReconciliationExtendMapper.deleteByExample(example);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
    }

    /**
     * 处理计算公式
     *
     * @param formula
     * @param systemPrice
     * @param billingPrice
     * @return
     */
    public BigDecimal calculate(String formula, BigDecimal systemPrice, BigDecimal billingPrice) {
        try {
            // 将字段名和字段值放入map中
            Map<String, BigDecimal> variables = new HashMap<>();
            variables.put("systemPrice", systemPrice);
            variables.put("billingPrice", billingPrice);

            // 替换公式中的字段名为字段值
            for (Map.Entry<String, BigDecimal> entry : variables.entrySet()) {
                formula = formula.replace(entry.getKey(), entry.getValue().toString());
            }

            // 使用JavaScript引擎计算表达式结果
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("JavaScript");
            Object result = engine.eval(formula);

            // 将结果转换为BigDecimal返回
            if (result instanceof Integer || result instanceof Double || result instanceof Float) {
                return new BigDecimal(result.toString());
            } else {
                throw new IllegalArgumentException("Invalid result type");
            }
        } catch (ScriptException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Calculation failed: " + e.getMessage());
        }
    }
}