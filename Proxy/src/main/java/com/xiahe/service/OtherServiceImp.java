package com.xiahe.service;

import com.xiahe.dao.OtherDao;
import com.xiahe.entity.Other;
import org.springframework.stereotype.Service;

//扩展类服务
@Service
public class OtherServiceImp extends ServiceImp<Other> implements OtherService {

    public OtherServiceImp() {
        super(OtherDao.class);
    }

}
