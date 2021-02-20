package MultiThread;

/**
 * @Classname CreateThreadDemo2
 * @Description 实现Runnable接口
 * @Date 2019/4/21 20:30
 * @Created by 14241
 */
public class CreateThreadDemo2 implements Runnable {


    public void run() {
        int i=0;
        while (true){
            System.out.println("线程"+i+"执行了...");
            i+=1;
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        //将线程任务传给线程对象
        Thread thread1 = new Thread(new CreateThreadDemo2());
        Thread thread2 = new Thread(new CreateThreadDemo2());
        //启动线程
        thread1.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.start();
    }
}
