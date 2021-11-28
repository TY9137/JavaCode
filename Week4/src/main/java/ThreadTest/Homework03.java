package ThreadTest;

import java.util.concurrent.*;

public class Homework03 {

    public static void main(String[] args) {

        long start=System.currentTimeMillis();

//        int result = sum(); //这是得到的返回值
//        // 确保  拿到result 并输出
//        System.out.println("异步计算结果为："+result);

        //方法1
        FutureTask<Integer> task = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return sum();
            }
        });
        Thread thread = new Thread(task);
        thread.start();

//        //方法2
//        ExecutorService executor = Executors.newCachedThreadPool();
//        Future<Integer> task = executor.submit(new Callable<Integer>() {
//            public Integer call() throws Exception {
//                return sum();
//            }
//        });
//        executor.shutdown();
//
//
//        //方法3
//        CompletableFuture<Integer> task = CompletableFuture.supplyAsync(() -> {
//            return sum();
//        });
//        CompletableFuture.allOf(task);

        try {
            System.out.println("result: " + task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

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
