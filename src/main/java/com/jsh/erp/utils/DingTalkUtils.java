package com.jsh.erp.utils;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.request.OapiRobotSendRequest;
import com.dingtalk.api.response.OapiRobotSendResponse;
import com.taobao.api.ApiException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * 钉钉机器人工具类
 *
 * @author koyo
 * @since 2023/9/20
 **/
@Component
public class DingTalkUtils {

    private static String ACCESS_TOKEN;

    @Value("${DINGDING.WEBHOOK.COLD.BACKEND}")
    private String webhookToColdBackend;

    @PostConstruct
    public void AccessToken() {
        ACCESS_TOKEN = this.webhookToColdBackend;
    }

    public static String getAccessToken() {
        return ACCESS_TOKEN;
    }

    //  private static final String SECRET = "2275868241";

    /**
     * 消息类型
     */
    private static final String MSG_TYPE_TEXT = "text";
    private static final String MSG_TYPE_LINK = "link";
    private static final String MSG_TYPE_MARKDOWN = "markdown";
    private static final String MSG_TYPE_ACTION_CARD = "actionCard";
    private static final String MSG_TYPE_FEED_CARD = "feedCard";

    /**
     * 发送普通文本消息,详细教程参考：https://blog.csdn.net/m0_37583655/article/details/124826768
     *
     * @param content    文本消息
     * @param mobileList 指定@ 联系人
     * @param isAtAll    是否@ 全部联系人
     * @return OapiRobotSendResponse
     */
    public static OapiRobotSendResponse sendMessageByText(String content, List<String> mobileList, boolean isAtAll,
                                                          String webhook) {
        if (webhook == null) {//判断是否有指定钉钉群，没有就使用默认
            webhook = ACCESS_TOKEN;
        }
        DefaultDingTalkClient client = new DefaultDingTalkClient(webhook);
        if (StringUtils.isEmpty(content)) {
            return null;
        }


        //参数	参数类型	必须	说明
        //msgtype	String	是	消息类型，此时固定为：text
        //content	String	是	消息内容
        //atMobiles	Array	否	被@人的手机号(在content里添加@人的手机号)
        //isAtAll	bool	否	@所有人时：true，否则为：false
        OapiRobotSendRequest.Text text = new OapiRobotSendRequest.Text();
        text.setContent(content);
        OapiRobotSendRequest request = new OapiRobotSendRequest();
        if (!CollectionUtils.isEmpty(mobileList)) {
            // 发送消息并@ 以下手机号联系人
            OapiRobotSendRequest.At at = new OapiRobotSendRequest.At();
            at.setAtMobiles(mobileList);
            at.setIsAtAll(isAtAll);
            request.setAt(at);
        }
        request.setMsgtype(DingTalkUtils.MSG_TYPE_TEXT);
        request.setText(text);

        OapiRobotSendResponse response = new OapiRobotSendResponse();
        try {
            response = client.execute(request);
        } catch (ApiException e) {
            //  log.error("[发送普通文本消息]: 发送消息失败, 异常捕获{}", e.getMessage());
            System.out.println("e = " + e);
        }
        return response;
    }

}
