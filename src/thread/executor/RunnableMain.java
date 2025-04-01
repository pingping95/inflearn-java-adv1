package thread.executor;

import java.util.Random;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;


public class RunnableMain {

    public static void main(String[] args) throws InterruptedException {

        // runnable을 구현한 클래스를 활용하여 task 인스턴스를 만들고 Thread를 만들 때 task를 제출한다.
        MyRunnable task = new MyRunnable();
        Thread thread = new Thread(task, "Thread-1");

        thread.start();
        thread.join();

        int value = task.value;
        log("result value is " + value);
    }

    static class MyRunnable implements Runnable {

        int value;

        @Override
        public void run() {
            log("Runnable 시작");
            sleep(2000);
            value = new Random().nextInt(10);
            log("created value : " + value);
            log("Runnable 완료");
        }
    }
}
