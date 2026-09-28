import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PlatformThreadMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService excutor = Executors.newFixedThreadPool(1000);
        long startTime = System.currentTimeMillis();

        List<Future<String>> futures = new ArrayList<>();

        for (int i=0; i<10000; i++) {
            Future future = excutor.submit(() -> {
                try {
                    return callTest();
                } catch(InterruptedException e) {
                    e.printStackTrace();
                    return "FAIL";
                }
            });

            futures.add(future);
        }

        int cnt = 0;
        for (Future<String> future : futures) {
            System.out.println(future.get() + "_" + cnt++);
        }

        long endTime = System.currentTimeMillis();

        System.out.println("걸린 시간: " + (endTime - startTime) + "ms");
    }

    private static String callTest() throws InterruptedException {
        Thread.sleep(1000);
        return "OK";
    }
}