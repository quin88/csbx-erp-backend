package com.jsh.erp.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.datasource.entities.SupermarketAccount;
import com.jsh.erp.datasource.entities.SupermarketSupplier;
import com.jsh.erp.service.supermarketAccount.SupermarketAccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/supermarketUnit")
@Api(tags = {"商超账户管理"})
public class SupermarketAccountController {

    @Resource
    private SupermarketAccountService supermarketAccountService;

    @GetMapping(value = "/findAccountListBySupplierId")
    @ApiOperation(value = "根据供应商id查询")
    public JSONArray findAccountListBySupplierId(@RequestParam(value = "supplierId") Long supplierId, HttpServletRequest request) {
        JSONArray array = new JSONArray();
        try {
            List<SupermarketAccount> accountList = supermarketAccountService.findAccountListBySupplierId(supplierId, request);
            if (accountList != null) {
                JSONArray dateArray = new JSONArray();
                for (SupermarketAccount account : accountList) {
                    JSONObject item = new JSONObject();
                    item.put("id", account.getId());
                    item.put("supplierId", account.getSupplierId());
                    item.put("accountName", account.getAccountName());
                    item.put("accountNumber", account.getAccountNumber());
                    item.put("bankName", account.getBankName());
                    item.put("remark", account.getRemark());
                    dateArray.add(item);
                }
                array = dateArray;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return array;
    }
}
