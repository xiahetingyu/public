package com.xiahe.service;

import com.xiahe.entity.Page;
import com.xiahe.entity.Recharge;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public interface RechargeService extends Service<Recharge> {

    List<Recharge> selectps(Model model, Page page);

    boolean recharge(Recharge recharge);

    void alipay(HttpSession session, HttpServletResponse response, Recharge recharge);

    String generate(Model model, HttpSession session, Recharge recharge);

}
