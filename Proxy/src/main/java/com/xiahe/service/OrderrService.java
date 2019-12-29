package com.xiahe.service;

import com.xiahe.entity.Orderr;
import com.xiahe.entity.Page;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface OrderrService extends Service<Orderr> {

    List<Orderr> selectps(Model model, Page page);

    //生成订单
    String generate(Model model, HttpSession session, Orderr orderr);

    //写入订单
    boolean orderr(Orderr orderr);

}
