package chufeng.com.Thread;

//模拟龟兔赛跑
public class Race implements Runnable {
    private static String Winner;
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            //模拟乌龟休息
            if(Thread.currentThread().getName().equals("兔子") && i%10==0){
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
            //判断比赛是否结束
            if(isGameOver(i)){
                break;
            }
            System.out.println(Thread.currentThread().getName()+"--->跑了"+i+"步");
        }

    }

    //判断比赛是否结束
    public boolean isGameOver(int step){
        if (Winner!=null){
            return true;
        }else{
            if(step>=100){
                Winner=Thread.currentThread().getName();
                System.out.println("winner is: "+Winner);
                return true;
            }else {
                return  false;
            }
        }
    }

    public static void main(String[] args) {
        Race race=new Race();
        new Thread(race,"兔子").start();
        new Thread(race,"乌龟").start();
    }
}
