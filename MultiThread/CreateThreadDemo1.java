package MultiThread;

/**
 * @Classname CreateeThreadDemo1
 * @Description 继承Thread类
 * @Date 2019/4/21 20:40
 * @Createed by 14241
 */
public class CreateThreadDemo1 extends Thread{
    /**
     * 构造方法：继承父类方法的Thread(String name)；方法
     * @param name
     */
    public CreateThreadDemo1(String name){
        super(name);
    }

    @Override
    public void run() {
        int i=0;
        while (!interrupted()){
            System.out.println(currentThread().getName()+"线程执行了..."+i);
            i++;
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        CreateThreadDemo1 d1 = new CreateThreadDemo1("first");
        CreateThreadDemo1 d2 = new CreateThreadDemo1("second");

        d1.start();
        try {
            d1.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        d2.start();
        d1.interrupt();  //中断第一个线程

    }
}
