package bingfa;

import java.util.concurrent.CountDownLatch;

/**
 * 方法 7  通过 CountDownLatch 方法 等待
 **/
public class func7 {
    public static int sum = 0;

    static class demo implements Runnable {
        private CountDownLatch latch;

        public demo(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            synchronized (this) {
                sum = sum();
                latch.countDown();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法

        CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(new demo(countDownLatch)).start();
        countDownLatch.await();
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

