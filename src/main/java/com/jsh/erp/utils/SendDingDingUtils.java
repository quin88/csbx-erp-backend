package com.jsh.erp.utils;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 发送钉钉通知工具类
 *
 * @author koyo
 * @since 2023/9/20
 **/
@Component
public class SendDingDingUtils {

    @Resource
    DingTalkUtils dingTalkUtils;

    public void sendDingDingUtils(String content, String webhook) {

        //发送消息时@以下手机号联系人,暂时不开放
        List<String> list = new ArrayList<>();
        // list.add("152XXX");
        //是否@所有人
        boolean isSendAll = false;
        dingTalkUtils.sendMessageByText(content, list, isSendAll, webhook);
    }
}
