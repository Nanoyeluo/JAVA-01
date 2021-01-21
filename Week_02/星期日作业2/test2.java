package java0.nio01;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.io.IOException;
import java.time.Duration;

/**
 * @author Nano
 * @ClassName test2
 * @Description TODO
 * @Date 2021/1/18 11:56
 * @Version 1.0
 **/
public class test2 {
    public static void main(String[] args) {

        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        Request request = new Request.Builder().url("http://localhost:8801")
                 .build();
        try (Response response = okHttpClient.newCall(request).execute()) {
            ResponseBody body = response.body();
            if (response.isSuccessful()) {
                System.out.println(body.string());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
