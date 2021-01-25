package chufeng.com.Thread;

//多个线程操作同一个对象，买火车票的例子
public class TestThread4 implements Runnable{
    private int ticketNums=20;
    @Override
    public void run() {
        while(true){
            if(ticketNums<0){
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"--->拿到了第"+ticketNums--+"票");
        }
    }

    public static void main(String[] args) {
        TestThread4 ticket = new TestThread4();
        new Thread(ticket,"Kevin").start();
        new Thread(ticket,"James").start();
        new Thread(ticket,"Harden").start();
    }
}
