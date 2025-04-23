class PerformanceTest {
    public void longRunningTask() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("Task completed.");
    }
}

public class TimeoutTest {
    public static void main(String[] args) {
        PerformanceTest test = new PerformanceTest();

        try {
            test.longRunningTask();
        } catch (InterruptedException e) {
            System.out.println("Timeout occurred.");
        }
    }
}