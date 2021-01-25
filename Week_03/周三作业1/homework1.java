package java0.nio01;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Nano
 * @ClassName homework1
 * @Description TODO
 * @Date 2021/1/21 19:55
 * @Version 1.0
 **/
public class homework1 {
    public static void main(String[] args) throws IOException {

        ExecutorService executorService = Executors.newFixedThreadPool(
                Runtime.getRuntime().availableProcessors() + 2);
        final ServerSocket serverSocket = new ServerSocket(8808);
        while (true) {
            try {
                final Socket socket = serverSocket.accept();
                executorService.execute(() -> service(socket));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void service(Socket socket) {
        try {
//            Thread.sleep(5);
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            printWriter.println("HTTP/1.1 200 OK");
            printWriter.println("Content-Type:text/html;charset=utf-8");
            String bodystr = null;
            OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
            Request request = new Request.Builder().url("http://localhost:8802")
                    .build();
            try (Response response = okHttpClient.newCall(request).execute()) {
                ResponseBody body = response.body();
                if (response.isSuccessful()) {
                    bodystr = body.string();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            String body = "hello,nio";
            printWriter.println("Content-Length:" + bodystr.getBytes().length);
            printWriter.println();
            printWriter.write(bodystr);
            printWriter.close();
            socket.close();
        } catch (IOException e) { // | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
