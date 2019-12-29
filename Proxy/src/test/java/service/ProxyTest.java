package service;

import com.xiahe.dao.ProxyEDao;
import com.xiahe.entity.ProxyE;
import com.xiahe.service.Service;
import com.xiahe.service.ServiceImp;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.List;

public class ProxyTest {

    @Test
    public void proxyInsertS() {
        Service<ProxyE> service = new ServiceImp<ProxyE>(ProxyEDao.class);
        ProxyE proxy = new ProxyE();
        proxy.setProxye("192.168.10.3:997304");
        proxy.setIp("192.168.10.3");
        proxy.setPort(997304);
        service.insert(proxy);
    }

    @Test
    public void proxyUpdateS() {
        Service<ProxyE> service = new ServiceImp<ProxyE>(ProxyEDao.class);
        ProxyE proxy = new ProxyE();
        proxy.setProxye("192.168.10.3:997304");
        proxy = service.select(proxy);
        proxy.setVer(2);
        proxy.setTime(new Timestamp(System.currentTimeMillis()));
        service.update(proxy);
    }

    @Test
    public void proxySelectS() {
        Service<ProxyE> service = new ServiceImp<ProxyE>(ProxyEDao.class);
        ProxyE proxy = new ProxyE();
        proxy.setProxye("192.168.10.3:997304");

        proxy = service.select(proxy);
        System.out.println(proxy);
    }

    @Test
    public void proxySelectsS() {
        Service<ProxyE> service = new ServiceImp<ProxyE>(ProxyEDao.class);
        List<ProxyE> selects = service.selects();
        for (ProxyE proxy : selects) {
            System.out.println(proxy);
        }
    }

}
