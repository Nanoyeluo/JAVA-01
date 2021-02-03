package bingfa;

/**
 * 方法 6  通过 while(true) 循环 判断 线程是否还活着 方法 等待
 **/
public class func6 {
    public static int sum = 0;

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法
        Thread thread = new Thread(() -> {
            sum = sum();
        });
        thread.start();
        while(thread.isAlive() == true){
        }
        System.out.println("异步计算结果为：" + sum);

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
