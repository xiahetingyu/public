package com.xiahe.entity;

import java.net.InetSocketAddress;
import java.net.Proxy;

//用于代理
public class ProxyE extends Entity {
    private String proxye;
    private String ip;
    private int port;
    private int ver;
    private transient Proxy proxy;

    public String getProxye() {
        return proxye;
    }

    public void setProxye(String proxye) {
        this.proxye = proxye;
    }

    public String getIp() {
        if (ip == null && proxye != null) {
            ip = proxye.split(":")[0];
        }
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        if (port == 0 && proxye != null) {
            port = Integer.valueOf(proxye.split(":")[1]);
        }
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getVer() {
        return ver;
    }

    public void setVer(int ver) {
        this.ver = ver;
    }

    // 获得代理的时候返回真正可用的代理
    public synchronized Proxy getProxy() {
        if (proxy == null) {
            InetSocketAddress inetSocketAddress = new InetSocketAddress(ip, port);
            proxy = new Proxy(Proxy.Type.HTTP, inetSocketAddress);
        }
        return proxy;
    }

    public void setProxy(Proxy proxy) {
        this.proxy = proxy;
    }

    @Override
    public String toString() {
        return "ProxyE{" +
                "proxye='" + proxye + '\'' +
                ", ip='" + ip + '\'' +
                ", port=" + port +
                ", ver=" + ver +
                ", proxy=" + proxy +
                "} " + super.toString();
    }

}
