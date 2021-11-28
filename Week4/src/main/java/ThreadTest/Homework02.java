package ThreadTest;

public class Homework02 extends Thread {
    private int rst;
    public void run()
    {
        rst=sum();
    }

    public static void main(String[] args) throws InterruptedException {
        long start=System.currentTimeMillis();
        Homework02 t1 = new Homework02();
        t1.start();

        t1.join();
        System.out.println("result: " + t1.rst);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }

    private static int sum() {
        return fibo(20);
    }

    private static int fibo(int a) {
        if ( a < 2)
            return 1;
        return fibo(a-1) + fibo(a-2);
    }
}
