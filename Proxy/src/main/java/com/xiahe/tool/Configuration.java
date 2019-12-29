package com.xiahe.tool;

public class Configuration {

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016092900622558";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCcJgwf7HgioKV9am7Pp65vwvnwN+wy9bGzM9/MmiyhHvIwusML5CmZ/TtG7UPKiN2TuxHMzfQs7KkWFb2T9otHCtUchqaG8MzF9GAPNMjhsz2MNw4y1tbCHkcY0yG/goqfA8HTRDQBnqoIkDPSy/h7gO/bHXDruHaAwLWm6pZtf4I170l7TEk8CjG2A7tPRMFJ091mzRdSoNeD59l/HrUvl3pXe4cnhoUF+BlXIEf+LUWEpo4sl0yMl9ujLj29JISzP3R3qELxWnPMZcWxQ28JdiyKsHOPO1eG6wJr9ezw8jIN/yGdCwBTYXngYlL7cMF71p2t7DEPLvkXdGJUbN5xAgMBAAECggEBAJeH+LY2NbNs8IxP8C9GS2qb7Q8oReiCNCtyyNl2OJ83N9MAOu3cQl70t0SyVdpDjbuii7iTmUTLeZ88A9iGJk0P/xYKuao0HpRv/ZRkJhmZZr4eY4IEqS6CUX6Oza5a0YlVDRCnnEyCHAHpZtFHLeE0lA+wd3fZb+6slNvhxY+F7K2X82fhgHUzOQGf4z/RkKGDQydyuZPpOyosXRKA28eSI/JOSgJd2ubVzqzQsfhGCUtvDkdYg4gQ8y2eSW+brz+CpHvxcxZ4NUM10aAIPIvBx4MGk7/3oDAL1mPCiEwDVifa9hJYy39JLzOlCGCaJ/4/UHHACG2flj3PM+6ABB0CgYEAzgs+Vcsu0yql5pCFwBpf02au5iBGVnw6vMtCKvhqlXENj04Gg1t/fHHQL8JaJEymxOv1xr7miOm92MQs4lA0m/czDoAHxw17wSlRRnrL1YE4RSTSwUoFEHV2PQtEwOJE8EHYieJ5gFHlNwzmmA9itgsgfX7YaG1vVJzsNlFZ79cCgYEAwgHlqHxFRv6CwGXQyNs3lNEfuO8dfFBIhdGV2HUbCinRudjRxEfHhspv6uQPsGpQsN54aTZpuDTJvotzsXw0TmYWFUBPgSKjVLX6Z/a0SBkVg4VZ1cdWfJ78n91AujKfnGBQizifaWyKm+ahXrKc4ZrC/M9cEWKSnObN9lU2evcCgYEAsNL/XPtxJPH9zEANOM6pnDAMOxxJoOEeO3WoRF5KghOykmBgwIxefTrjcok1eN97Y5Yop7ae+7K1JXk+F77DV3IvE+uWQSJ2KVA/GuA5W/J4iwZOBGl0rSpRHZQ1Hd9RUGsB3VtJ8HDX6IWew7K4gQhNisW4DO6V06SUJw1rxKMCgYBolJ04NcUigA/7publX0aW8iQnjL5YRO7TNCeSh44L7H8hr79kD01/W6D4/fd3Idhdf49pJ+vVYJ9gF8xF4K5RlLZSvlgdRI7HG1HguRx1wQ/X1gqXMt1sUEfd5Wb++EsSANlqMxu7uMb/Q1O5uI7ZDpQNs7ntpTVjXwenwkecAQKBgHycxhFcoDGH78cuJKE50SrxddsTh1KLaTBcvKGL2gQTzoahVXTvgauepvt5aUk+SNDo03JBd2n9tjZ6KhG+xZgeEUiVDcSIIMCES01N6br689l0v94F+Kdj/XD11gQtg/uvsjuhWnPchGRC1Z/2Rrdu8fxA62KvGjLSxBgC28xz";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAndRIBcXQfsbO/pMvGBDQKD+PjrLV8IcuPtaAyav9gIKiwREL7cZGj0M+tyCvq+4QegN06ypNDd72jeC2Ix56GGHuDRYyuiUhkDq8+AY5jkNLRv8X6aSTkZ41NwwCInbDmM781v9ssjHsWRFfK9pf74RO4z6Ou/OrHTl4ZFT87CZvKNuHoTHLFqyONEsKNYCBqN+45uSfMu/0ojHN9RlW+vD85WIpnVH4YMrUiYSqawmTlwVzeP6e7kysYdCA5NYdqVfKFQUaKPOU9f+TBuI1XQyv7ZU8//wT0DiPBgXjRqyrdjW45gAIL/u9wz5FM2UwU8szzoWlQmfrgKadR18nPwIDAQAB";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:8989/Proxy/recharge/recharge.do";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";


}
