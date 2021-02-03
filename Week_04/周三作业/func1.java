package bingfa;

import java.util.concurrent.Callable;

/**
 * 方法一：通过callable接口创建一个线程 然后 直接获取返回值
 */
public class func1 {

    public static void main(String[] args) throws Exception {

        long start = System.currentTimeMillis();
        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法
        Integer result = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return sum();
            }
        }.call();

        // 确保  拿到result 并输出
        System.out.println("异步计算结果为：" + result);

        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");

        // 然后退出main线程
    }

    private static int sum() {
        return fibo(36);
    }

    private static int fibo(int a) {
        if (a < 2) {
            return 1;
        }
        return fibo(a - 1) + fibo(a - 2);
    }
}
