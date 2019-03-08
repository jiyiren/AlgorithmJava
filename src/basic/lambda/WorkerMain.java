package basic.lambda;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/6/9 下午2:05
 * @Description
 */

public class WorkerMain {

    public static void execute(WorkerInterface worker) {
        worker.doSomeWork();
    }

    public static void main(String[] args) {
        //1.
        execute(new WorkerInterface() {
            @Override
            public void doSomeWork() {
                System.out.println("Worker invoked using Anonymous class");
            }
        });
        //2.
        execute(() -> {
            System.out.println("Worker invoked using Lambda expression");
            System.out.println("The second !");
        });

    }
}
