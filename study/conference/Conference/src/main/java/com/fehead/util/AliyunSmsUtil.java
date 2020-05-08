package com.fehead.util;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author Nightnessss 2019/2/22 15:15
 */
@Component
@PropertySource("classpath:sms.properties")
public class AliyunSmsUtil {
    @Autowired
    static Environment evn;
/*
pom.xml
<dependency>
  <groupId>com.aliyun</groupId>
  <artifactId>aliyun-java-sdk-core</artifactId>
  <version>4.0.3</version>
</dependency>
*/

    /**
     * 新版本：阿里云云通信发送短信通知
     * @param smsModelId 短信模板ID，传入的模板必须是在阿里大于“管理中心-短信模板管理”中的可用模板。示例：sms.TemplateNotice
     * @param modelParam   模板内容里面的变量
     * @param phone   用户手机号码
     * @return boolean true成功false失败
     */
    public static boolean sendSms(String smsModelId, JSONPObject modelParam, String phone) {

        boolean result = false;

        String appKey = evn.getProperty("sms.AppKey");
        String secret = evn.getProperty("sms.Seret");
        String regionId = evn.getProperty("sms.RegionId");
        String signName = evn.getProperty("sms.SignNameJson");
        String smsModel = evn.getProperty(smsModelId);

        DefaultProfile profile = DefaultProfile.getProfile(regionId, appKey, secret);
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        //request.setProtocol(ProtocolType.HTTPS);
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", regionId);
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName", signName);
        request.putQueryParameter("TemplateCode", smsModel);
        request.putQueryParameter("TemplateParamJson", modelParam.toString());
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
            result = true;
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static boolean sendBatchSms(String smsModelId, JSONPObject modelParam, JSONPObject phone) {
        String appKey = evn.getProperty("sms.AppKey");
        String secret = evn.getProperty("sms.Seret");
        String regionId = evn.getProperty("sms.RegionId");
        String signName = evn.getProperty("sms.SignNameJson");
        String smsModel = evn.getProperty(smsModelId);

        boolean result = false;
        DefaultProfile profile = DefaultProfile.getProfile(regionId, appKey, secret);
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        //request.setProtocol(ProtocolType.HTTPS);
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendBatchSms");
        // 选填，地区编号
        request.putQueryParameter("RegionId", regionId);
        // 必填，电话号码
        request.putQueryParameter("PhoneNumberJson", phone.toString());
        // 必填，签名
        request.putQueryParameter("SignNameJson", signName);
        // 必填，模板
        request.putQueryParameter("TemplateCode", smsModel);
        // 选填，模板变量
        request.putQueryParameter("TemplateParamJson", modelParam.toString());
        // 选填，短信扩展码
//        request.putQueryParameter("SmsUpExtendCodeJson", "");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
            result = true;
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }

        return result;
    }
}