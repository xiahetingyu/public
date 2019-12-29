package com.xiahe.core;

import com.xiahe.dao.ProxyEDao;
import com.xiahe.entity.ProxyE;
import com.xiahe.service.Service;
import com.xiahe.service.ServiceImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

//收集器核心
public class Core {

    public Core() {
        collect();
        ver();
        result();
        timer();
    }

    // 收集器集合
    private List<Collector> collectors;

    // 收集开始
    private void collect() {
        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                // 创建收集器集合
                collectors = new ArrayList<Collector>();
                collectors.add(new Implement_89IP());// 添加收集器
                collectors.add(new Implement_QiYun());// 添加收集器
                while (true) {
                    for (Collector collector : collectors) {
                        collector.collect();// 开始收集
                    }
                    try {
                        Thread.sleep(5 * 60000);
                    } catch (Exception e) {
                    }
                }
            }
        };
        Configuration.EXECUTOR.execute(runnable);
    }

    // 验证开始
    private void ver() {
        // 并发验证器
        for (int i = 0; i < 64; i++) {
            Configuration.EXECUTOR.execute(new Verification());
        }
    }

    // 代理服务
    private Service<ProxyE> service = new ServiceImp<>(ProxyEDao.class);

    // 结果处理
    private void result() {
        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                while (true) {
                    try {
                        // 从队列中取出验证成功的代理IP
                        ProxyE take = Configuration.CACHE.take();
                        take.setOther("verification");// 添加标记
                        // 检查是否已经存在与数据库中
                        List<ProxyE> selects = service.selects("where proxye = '" + take.getProxye() + "'");
                        ProxyE select = selects.size() > 0 ? selects.get(0) : null;
                        if (select != null) {// 已经存在
                            if (take.getVer() < 0 && Verification.isOnline()) {// 验证失败
                                service.delete(select);// 删除代理IP
                                continue;// 结束本次循环
                            }
                            select.setVer(take.getVer() + 1);
                            service.update(select);// 更新代理
                        }
                        if (select == null) {// 不存在
                            service.insert(take);// 增加新的代理
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Configuration.EXECUTOR.execute(runnable);
    }

    // 定时任务
    private Timer timer = new Timer();
    private TimerTask timerTask;

    // 定时开始
    private void timer() {
        timerTask = new TimerTask() {

            @Override
            public void run() {
                // 验证库中的代理IP
                System.out.println("验证任务");
                // 取出距上次验证时间最长的5000条代理进行验证
                List<ProxyE> selects = service.selects("order by time asc limit 5000");
                for (ProxyE proxyE : selects) {
                    // 存入待验证队列
                    try {
                        Configuration.VERIFICATION.put(proxyE);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        // 系统启动一个小时后开始执行|每三小时执行一次
        timer.schedule(timerTask, 60 * 60 * 1000, 3 * 60 * 60 * 1000);
    }

}
