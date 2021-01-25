package chufeng.com.Thread.syn;
//不安全的买票
public class UnsafeBuyTicket {
    public static void main(String[] args) {
        buyTicket ticket = new buyTicket();
        new Thread(ticket,"小麦").start();
        new Thread(ticket,"小明").start();
        new Thread(ticket,"涛哥").start();
    }
}
class buyTicket implements Runnable{
    private int ticketNums=10;
    boolean flag=true;
    private synchronized void buy() throws InterruptedException {
        if(ticketNums<=0){
            flag=false;
            return;
        }
        //模拟延时
        Thread.sleep(100);
        //买票
        System.out.println(Thread.currentThread().getName()+"拿到"+ticketNums--);
    }
    @Override
    public void run() {
        while (flag){
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
