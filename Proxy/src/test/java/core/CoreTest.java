package core;

import com.xiahe.core.Configuration;
import com.xiahe.core.Core;
import com.xiahe.tool.NetworkTools;
import org.junit.Test;

public class CoreTest {

    // 加载浏览器请求头测试
    @Test
    public void browserTest() {
        for (String string : Configuration.BROWSER) {
            System.out.println(string);
        }
    }

    // 验证地址测试
    @Test
    public void verHostTest() throws Exception {
        String result = NetworkTools.httpsString(Configuration.VER, "GET", null, null, Configuration.BROWSER, null);
        System.out.println(result);
    }

    // 验证核心
    @Test
    public void coreTest() throws Exception {
        new Core();
        Thread.sleep(120 * 60000);
    }

}
