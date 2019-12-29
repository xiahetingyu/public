package other;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import org.junit.Test;

public class SMSCode {

    @Test
    public void smsTest() {
//		用户登录名称 sms@1553760289028739.onaliyun.com
//		AccessKey ID LTAI4MKdLtKH8GOd
//		AccessKeySecret JKuZ26F1Vcu1SfSMybzGR8SWdlgTdw
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4MKdLtKH8GOd", "JKuZ26F1Vcu1SfSMybzGR8SWdlgTdw");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        // request.setProtocol(ProtocolType.HTTPS);
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", "18838985315");
        request.putQueryParameter("SignName", "夏荷听雨");
        request.putQueryParameter("TemplateCode", "SMS_166377395");
        request.putQueryParameter("TemplateParam", "{\"code\":\"123456\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}