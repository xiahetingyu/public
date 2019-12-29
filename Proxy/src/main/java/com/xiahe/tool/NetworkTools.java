package com.xiahe.tool;

import javax.net.ssl.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class NetworkTools {
    public static int[] statistics = new int[4];
    public static int time = 8000;
    public static boolean debug = false;

    // http
    public static String httpString(String url, String method, String data, String charset, String[] property,
                                    Proxy proxy) throws Exception {
        // proxy
        URL temp = new URL(url);
        HttpURLConnection httpURLConnection = (HttpURLConnection) (proxy == null ? temp.openConnection()
                : temp.openConnection(proxy));
        // method
        httpURLConnection.setRequestMethod(method == null ? "POST" : method);
        // time
        httpURLConnection.setReadTimeout(time);
        // property
        if (property != null) {
            for (int i = 0; i < property.length; i += 2) {
                httpURLConnection.setRequestProperty(property[i], property[i + 1]);
            }
        }
        // data
        if (data != null) {
            httpURLConnection.setDoOutput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(data.getBytes(charset == null ? "UTF-8" : charset));
            outputStream.flush();
            outputStream.close();
        }
        // result
        InputStream inputStream = httpURLConnection.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charset == null ? "UTF-8" : charset);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line = "", result = "";
        while ((line = bufferedReader.readLine()) != null) {
            result += line + "\n";
        }
        // close
        bufferedReader.close();
        inputStreamReader.close();
        inputStream.close();
        httpURLConnection.disconnect();
        if (debug) {
            System.out.println("NetworkTools-->httpString:[url=" + url + ":statistics=" + ++statistics[0] + "]");
        }
        return result;
    }

    // httpStream
    public static InputStream httpStream(String url, String method, String data, String charset, String[] property,
                                         Proxy proxy) throws Exception {
        // proxy
        URL temp = new URL(url);
        HttpURLConnection httpURLConnection = (HttpURLConnection) (proxy == null ? temp.openConnection()
                : temp.openConnection(proxy));
        // method
        httpURLConnection.setRequestMethod(method == null ? "POST" : method);
        // time
        httpURLConnection.setReadTimeout(time);
        // property
        if (property != null) {
            for (int i = 0; i < property.length; i += 2) {
                httpURLConnection.setRequestProperty(property[i], property[i + 1]);
            }
        }
        // data
        if (data != null) {
            httpURLConnection.setDoOutput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(data.getBytes(charset == null ? "UTF-8" : charset));
            outputStream.flush();
            outputStream.close();
        }
        if (debug) {
            System.out.println("NetworkTools-->HttpStream:[url=" + url + ":statistics=" + ++statistics[1] + "]");
        }
        // result
        return httpURLConnection.getInputStream();
    }

    // https
    public static String httpsString(String url, String method, String data, String charset, String[] property,
                                     Proxy proxy) throws Exception {
        // proxy
        URL temp = new URL(url);
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) (proxy == null ? temp.openConnection()
                : temp.openConnection(proxy));
        // ssl
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, new TrustManager[]{new MyX509TrustManager()}, new SecureRandom());
        httpsURLConnection.setSSLSocketFactory(sslContext.getSocketFactory());
        httpsURLConnection.setHostnameVerifier(new MyHostnameVerifier());
        // method
        httpsURLConnection.setRequestMethod(method == null ? "POST" : method);
        // time
        httpsURLConnection.setReadTimeout(time);
        // property
        if (property != null) {
            for (int i = 0; i < property.length; i += 2) {
                httpsURLConnection.setRequestProperty(property[i], property[i + 1]);
            }
        }
        // data
        if (data != null) {
            httpsURLConnection.setDoOutput(true);
            OutputStream outputStream = httpsURLConnection.getOutputStream();
            outputStream.write(data.getBytes(charset == null ? "UTF-8" : charset));
            outputStream.flush();
            outputStream.close();
        }
        // result
        InputStream inputStream = httpsURLConnection.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charset == null ? "UTF-8" : charset);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line = "", result = "";
        while ((line = bufferedReader.readLine()) != null) {
            result += line + "\n";
        }
        // close
        bufferedReader.close();
        inputStreamReader.close();
        inputStream.close();
        httpsURLConnection.disconnect();
        if (debug) {
            System.out.println("NetworkTools-->HttpsString:[url=" + url + ":statistics=" + ++statistics[2] + "]");
        }
        return result;
    }

    // httpsStream
    public static InputStream httpsStream(String url, String method, String data, String charset, String[] property,
                                          Proxy proxy) throws Exception {
        // proxy
        URL temp = new URL(url);
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) (proxy == null ? temp.openConnection()
                : temp.openConnection(proxy));
        // ssl
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, new TrustManager[]{new MyX509TrustManager()}, new SecureRandom());
        httpsURLConnection.setSSLSocketFactory(sslContext.getSocketFactory());
        httpsURLConnection.setHostnameVerifier(new MyHostnameVerifier());
        // method
        httpsURLConnection.setRequestMethod(method == null ? "POST" : method);
        // time
        httpsURLConnection.setReadTimeout(time);
        // property
        if (property != null) {
            for (int i = 0; i < property.length; i += 2) {
                httpsURLConnection.setRequestProperty(property[i], property[i + 1]);
            }
        }
        // data
        if (data != null) {
            httpsURLConnection.setDoOutput(true);
            OutputStream outputStream = httpsURLConnection.getOutputStream();
            outputStream.write(data.getBytes(charset == null ? "UTF-8" : charset));
            outputStream.flush();
            outputStream.close();
        }
        if (debug) {
            System.out.println("NetworkTools-->HttpsStream:[url=" + url + ":statistics=" + ++statistics[3] + "]");
        }
        // result
        return httpsURLConnection.getInputStream();
    }

    // ////////////////////////////////////////Other//////////////////////////////////////////////////////
    public static class MyHostnameVerifier implements HostnameVerifier {

        @Override
        public boolean verify(String arg0, SSLSession arg1) {
            return false;
        }

    }

    public static class MyX509TrustManager implements X509TrustManager {

        @Override
        public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {

        }

        @Override
        public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {

        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

    }

}
