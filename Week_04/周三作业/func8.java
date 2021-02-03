package bingfa;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 方法 8  通过 CyclicBarrier 方法 等待
 **/
public class func8 {
    public static int sum = 0;

    static class demo implements Runnable {
        private CyclicBarrier cyc;

        public demo(CyclicBarrier cyc) {
            this.cyc = cyc;
        }

        @Override
        public void run() {
            synchronized (this) {
                sum = sum();
                try {
                    cyc.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法

        CyclicBarrier cyclicBarrier = new CyclicBarrier(1, new Runnable() {
            @Override
            public void run() {
                System.out.println("异步计算结果为：" + sum);

                System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
            }
        });
        new Thread(new demo(cyclicBarrier)).start();


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

