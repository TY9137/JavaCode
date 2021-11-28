package ThreadTest;

class MyThread implements Runnable { // 实现Runnable接口，作为线程的实现类
    public int rst;

    public MyThread() {
    }

    private static int sum() {
        return fibo(20);
    }

    private static int fibo(int a) {
        if (a < 2)
            return 1;
        return fibo(a - 1) + fibo(a - 2);
    }

    public void run() {  // 覆写run()方法，作为线程 的操作主体
        rst = sum();
    }
};

public class Homework1 {

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        MyThread mt1 = new MyThread();
        Thread t1 = new Thread(mt1);

        t1.start();
        t1.join();
        System.out.println("result: " + mt1.rst);
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
    }
}
