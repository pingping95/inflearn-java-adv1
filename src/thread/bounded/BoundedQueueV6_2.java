package thread.bounded;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import static util.MyLogger.log;

public class BoundedQueueV6_2 implements BoundedQueue {

    private BlockingQueue<String> queue;

    public BoundedQueueV6_2(int max) {
        queue = new ArrayBlockingQueue<>(max);
    }

    @Override
    public void put(String data) {
        // 성공 시 true
        // 버퍼 가득 차면 false
        boolean result = queue.offer(data);
        log("저장 시도 결과 = " + result);
    }

    @Override
    public String take() {
        // 버퍼에 데이터가 없으면 null
        return queue.poll();
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
