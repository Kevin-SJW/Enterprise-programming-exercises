package MultiThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Classname CreateThreadDemo4
 * @Description 创建带返回值的线程
 * @Date 2019/4/21 20:48
 *
 * @Created by 14241
 */
public class CreateThreadDemo4 implements Callable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CreateThreadDemo4 demo4 = new CreateThreadDemo4();

        /*FutureTask最终实现的是runnable接口*/
        FutureTask<Integer> task = new FutureTask<Integer>(demo4);

        Thread thread = new Thread(task);

        thread.start();

        System.out.println("我可以在这里做点别的业务逻辑...因为FutureTask是提前完成任务");
        //拿出线程执行的返回值
        Integer result = task.get();
        System.out.println("线程中运算的结果为:"+result);
    }

    //重写Callable接口的call方法
    @Override
    public Object call() throws Exception {
        int result = 1;
        System.out.println("业务逻辑计算中...");
        Thread.sleep(3000);
        return result;
    }
}
