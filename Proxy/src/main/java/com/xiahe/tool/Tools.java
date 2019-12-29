package com.xiahe.tool;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.xiahe.entity.User;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tools {

    // 合并数组
    public static String[] merge(String[]... sources) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < sources.length; i++) {
            for (int j = 0; j < sources[i].length; j++) {
                result.add(sources[i][j]);
            }
        }
        return result.toArray(new String[0]);
    }

    // 短信验证码
    public static boolean phoneCode(User user, HttpSession session) {
        try {
            // 准备环境
            DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4MKdLtKH8GOd",
                    "JKuZ26F1Vcu1SfSMybzGR8SWdlgTdw");
            IAcsClient client = new DefaultAcsClient(profile);
            // 生成验证码
            Random random = new Random();
            String nextInt = ("000000" + random.nextInt(1000000));
            nextInt = nextInt.substring(nextInt.length() - 6);

            // 构建发送请求
            CommonRequest request = new CommonRequest();
            request.setMethod(MethodType.POST);
            request.setDomain("dysmsapi.aliyuncs.com");
            request.setVersion("2017-05-25");
            request.setAction("SendSms");
            request.putQueryParameter("RegionId", "cn-hangzhou");
            request.putQueryParameter("PhoneNumbers", user.getUsername());
            request.putQueryParameter("SignName", "夏荷听雨");
            request.putQueryParameter("TemplateCode", "SMS_166377395");
            request.putQueryParameter("TemplateParam", "{\"code\":\"" + nextInt + "\"}");
            client.getCommonResponse(request);

            // 存验证码到Session
            session.setAttribute("phoneCode", nextInt);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // 系统验证码
    public static void systemCode(HttpServletRequest request, HttpServletResponse response) {
        try {
            String generateVerifyCode = SecurityCode.generateVerifyCode(4);
            request.getSession().setAttribute("systemCode", generateVerifyCode);
            BufferedImage image = SecurityCode.getImage(200, 80, generateVerifyCode);
            ImageIO.write(image, "png", response.getOutputStream());
            System.out.println(generateVerifyCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
