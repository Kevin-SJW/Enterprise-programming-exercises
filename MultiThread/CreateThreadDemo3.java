package MultiThread;

/**
 * @Classname CreateThreadDemo3
 * @Description 匿名内部类创建对象
 * @Date 2019/4/21 20:46
 * @Created by 14241
 */
public class CreateThreadDemo3 extends Thread{
    public static void main(String[] args) {
        //创建无参线程对象
        new Thread(){
            @Override
            public void run() {
                System.out.println("线程执行了...");
            }
        }.start();
        /**
         * 创建带线程任务的线程对象
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程执行了...");
            }
        }).start();
        /**
         * 创建带线程任务并且重写run方法的线程对象
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("runnable run 线程执行了...");
            }
        }){
            @Override
            public void run() {
                System.out.println("override run 线程执行了...");
            }
        }.start();
    }

}
