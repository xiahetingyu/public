package com.xiahe.service;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.xiahe.dao.RechargeDao;
import com.xiahe.entity.Other;
import com.xiahe.entity.Recharge;
import com.xiahe.entity.User;
import com.xiahe.tool.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;

//充值类服务
@Service
public class RechargeServiceImp extends ServiceImp<Recharge> implements RechargeService {

    public RechargeServiceImp() {
        super(RechargeDao.class);
    }

    @Override
    public boolean recharge(Recharge recharge) {
        if (insert(recharge)) {
            OtherService service = new OtherServiceImp();
            List<Other> selects = service.selects("where username = " + recharge.getUsername());
            Other other = selects.size() > 0 ? selects.get(0) : null;
            if (other != null) {
                other.setBalance(recharge.getAmount() + other.getBalance());
                service.update(other);
            }
        }
        return false;
    }

    //支付宝充值
    @Override
    public void alipay(HttpSession session, HttpServletResponse response, Recharge recharge) {
        session.setAttribute("recharge", recharge);
        //初始化
        AlipayClient alipayClient = new DefaultAlipayClient(Configuration.gatewayUrl, Configuration.app_id, Configuration.merchant_private_key, "json", Configuration.charset, Configuration.alipay_public_key, Configuration.sign_type);
        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(Configuration.return_url);

        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = System.currentTimeMillis() + "" + new Random().nextInt(999999);
        //付款金额，必填
        String total_amount = recharge.getAmount() + "";
        //订单名称，必填
        String subject = "账户充值-" + out_trade_no;

        alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\","
                + "\"total_amount\":\"" + total_amount + "\","
                + "\"subject\":\"" + subject + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        //请求
        try {
            String body1 = alipayClient.pageExecute(alipayRequest).getBody();
            response.setContentType("text/html;charset=utf-8");
            PrintWriter writer = response.getWriter();
            writer.println(body1);
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String generate(Model model, HttpSession session, Recharge recharge) {
        User user = (User) session.getAttribute("user");
        try {
            if (recharge.getUsername() != null) {//自定义金额
                recharge.setAmount(Integer.valueOf(recharge.getUsername()));
                recharge.setUsername(user.getUsername());
                recharge.setStatus(1);
                model.addAttribute("recharge", recharge);
                return "/front/rinvoice.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Integer integer = Integer.valueOf(recharge.getOther());
        recharge.setAmount(integer);
        recharge.setUsername(user.getUsername());
        recharge.setStatus(1);
        model.addAttribute("recharge", recharge);
        return "/front/rinvoice.jsp";
    }


}
