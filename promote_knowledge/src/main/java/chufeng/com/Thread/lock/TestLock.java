package chufeng.com.Thread.lock;

import java.util.concurrent.locks.ReentrantLock;

//测试lock锁
public class TestLock {


    public static void main(String[] args) {
        Mylock mylock=new Mylock();
        new Thread(mylock).start();
        new Thread(mylock).start();
        new Thread(mylock).start();
    }
}


class Mylock implements Runnable{
    int ticketNums=10;
    //定义lock锁
    private final ReentrantLock lock=new ReentrantLock();
    @Override
    public void run() {
        while (true){
            try{
                lock.lock();//加锁
                if(ticketNums>0){
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(ticketNums--);
                }else {
                    break;
                }
            }finally {
                lock.unlock();
            }

        }
    }
}