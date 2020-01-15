package com.secondary.sms.demo;
import java.io.UnsupportedEncodingException;
import com.alibaba.fastjson.JSON;
import com.secondary.sms.model.request.SmsSendRequest;
import com.secondary.sms.model.response.SmsSendResponse;
import com.secondary.sms.util.ChuangLanSmsUtil;

/**
 *
 * @author tianyh
 * @Description:普通短信发送
 */
public class SmsSendDemo {
    public static final String charset = "utf-8";

    public static void main(String[] args) throws UnsupportedEncodingException {
        //请求地址请登录253云通讯自助通平台查看或者询问您的商务负责人获取
        String smsSingleRequestServerUrl = "http://smssh1.253.com/msg/send/json";
        // 短信内容
        String msg = "【白桃说】大家好我是飞云";
        //手机号码
        String phone = "13082840282";
        //状态报告
        String report= "true";

        // 用户平台API账号(非登录账号,示例:N1234567)
        String account = "N7245350";
        // 用户平台API密码(非登录密码)
        String password = "MPKzvy6kEubf49";
        SmsSendRequest smsSingleRequest = new SmsSendRequest(account, password, msg, phone,report);

        String requestJson = JSON.toJSONString(smsSingleRequest);

        System.out.println("before request string is: " + requestJson);

        String response = ChuangLanSmsUtil.sendSmsByPost(smsSingleRequestServerUrl, requestJson);

        System.out.println("response after request result is :" + response);

        SmsSendResponse smsSingleResponse = JSON.parseObject(response, SmsSendResponse.class);

        System.out.println("response  toString is :" + smsSingleResponse);
    }
}
