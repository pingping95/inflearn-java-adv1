package thread.executor;

import java.util.Random;
import java.util.concurrent.*;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class CallableMainV1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // 고정된 사이즈의 Thread pool을 Executors가 제공해주는 것을 사용한다.
        // 이를 통해 ExecutorService를 생성할 수 있다.
        ExecutorService es = Executors.newFixedThreadPool(1);

        // submit 메서드로 Callable을 구현한 클래스로 작업을 제출한다.
        // MyCallable 인스턴스가 블로킹 큐에 전달 -> 스레드 풀에 있는 스레드가 작업을 실행한다.
        // 작업의 처리 결과는 Future 객체를 인터페이스를 통해 반환된다.
        Future<Integer> future = es.submit(new MyCallable());

        // future.get()을 통해 반환한 결과를 받을 수 있다.
        // InterruptedException, ExecutionException 체크 예외를 던진다.
        Integer result = future.get();
        log("result value = " + result);
        es.close();

    }

    static class MyCallable implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            log("Callable 시작");
            sleep(2000);
            int value = new Random().nextInt(10);
            log("Create value " + value);
            log("Callable 완료");
            return value;
        }
    }
}
