import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Future;

// Java code for thread creation by implementing
// the Runnable Interface
class MultithreadingDemo implements Runnable {
    String testItem;

    public MultithreadingDemo(String x) {
        this.testItem = x;
    }

    @Override
    public void run() {
        try {
            // Displaying the thread that is running
            System.out.println(
                    "Thread " + this.testItem
                            + " is running");
        } catch (Exception e) {
            // Throwing an exception
            System.out.println("Exception is caught");
        }
    }
}

// Main Class
class Multithread {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // int n = 8; // Number of threads
        // for (int i = 0; i < n; i++) {
        // Thread object = new Thread(new MultithreadingDemo(String.valueOf(i)));
        // object.start();
        // }

        ExecutorService threadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            threadPool.execute(new Runnable() {

                @Override
                public void run() {
                    System.out.println("Thread is running");

                }
                /* your task */ });

        }

            Callable<String> callable = () -> { return "FD"; };
            Future<String> rr = threadPool.submit(callable);
            System.out.print("RESULT IS: " + rr.get() + "\n");
            threadPool.shutdown();
            boolean finished = threadPool.awaitTermination(1, TimeUnit.MINUTES);
            // all tasks have finished or the time has been reached.

    }

}