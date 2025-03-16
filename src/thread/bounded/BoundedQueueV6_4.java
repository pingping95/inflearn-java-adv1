package thread.bounded;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import static util.MyLogger.log;

public class BoundedQueueV6_4 implements BoundedQueue {

    private BlockingQueue<String> queue;

    public BoundedQueueV6_4(int max) {
        queue = new ArrayBlockingQueue<>(max);
    }

    @Override
    public void put(String data) {
        // java.lang.IllegalStateException: Queue full
        queue.add(data);
    }

    @Override
    public String take() {
        // java.util.NoSuchElementException
        return queue.remove();
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
