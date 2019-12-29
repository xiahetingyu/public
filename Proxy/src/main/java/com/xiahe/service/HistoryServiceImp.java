package com.xiahe.service;

import com.xiahe.dao.HistoryDao;
import com.xiahe.entity.History;
import org.springframework.stereotype.Service;

//代理类服务
@Service
public class HistoryServiceImp extends ServiceImp<History> implements HistoryService {

    public HistoryServiceImp() {
        super(HistoryDao.class);
    }

}
