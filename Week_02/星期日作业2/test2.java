import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

import java.io.IOException;

/**
 * @author Nano
 * @ClassName test2
 * @Description TODO
 * @Date 2021/1/18 11:56
 * @Version 1.0
 **/
public class test2 {
    public static void main(String[] args) {
        HttpClient httpClient = new HttpClient();
        // 设置httpClient连接主机服务器超时时间：15000毫秒
        httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(15000);
        // 创建GET请求方法实例对象
        GetMethod getMethod = new GetMethod("http://localhost:8801");
        // 设置post请求超时时间
        getMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 60000);
        getMethod.addRequestHeader("Content-Type", "text/html; charset=UTF-8");
        try {
            int rspCode = httpClient.executeMethod(getMethod);
            //
            System.out.println("rspCode:" + rspCode);
            String result = getMethod.getResponseBodyAsString();
            System.out.println(result);
            getMethod.releaseConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
