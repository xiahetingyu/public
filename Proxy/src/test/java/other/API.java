package other;
import org.junit.Test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
public class API {

    //获取代理IP
    @Test
    public void api() throws Exception {
        String api = "http://localhost:8989/Proxy/proxy/take.do?username=xxx&password=xxx&phoneCode=xxx";
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(api).openConnection();
        httpURLConnection.setRequestMethod("GET");
        Scanner scanner = new Scanner(httpURLConnection.getInputStream());
        String result = scanner.nextLine();
        System.out.println(result);
    }

}
