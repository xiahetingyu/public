package com.xiahe.service;

import com.xiahe.entity.Page;
import com.xiahe.entity.ProxyE;
import com.xiahe.entity.User;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface ProxyEService extends Service<ProxyE> {

    //分页分条件查询
    List<ProxyE> selectps(Model model, Page page);

    //用户使用代理
    String take(User user, HttpServletResponse response);

}
