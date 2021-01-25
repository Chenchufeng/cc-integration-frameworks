package chufeng.com.Thread;

import chufeng.com.Thread.utils.DownloadUtils;

import java.util.concurrent.*;

//实现callable接口,  好处:可以定义返回值，可以跑出异常
public class TestCallable implements Callable<Boolean> {
    private String url;
    private String name;

    public TestCallable(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public Boolean call(){
        DownloadUtils.downLoadPicture(url,name);
        System.out.println("下载了文件名为:"+name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable t1 = new TestCallable("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3795757253,2048194183&fm=26&gp=0.jpg", "a1.jpg");
        TestCallable t2 = new TestCallable("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2233919607,492292383&fm=26&gp=0.jpg", "a2.jpg");
        TestCallable t3 = new TestCallable("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2229933833,3823819913&fm=26&gp=0.jpg", "a3.jpg");
        //创建执行服务
        ExecutorService ser= Executors.newFixedThreadPool(3);
        //提交执行
        Future<Boolean> submit1 = ser.submit(t1);
        Future<Boolean> submit2 = ser.submit(t2);
        Future<Boolean> submit3 = ser.submit(t3);
        //获取结果
        Boolean rs1 = submit1.get();
        Boolean rs2 = submit2.get();
        Boolean rs3 = submit3.get();
        System.out.println(rs1);
        System.out.println(rs2);
        System.out.println(rs3);
        //关闭服务
        ser.shutdownNow();
    }
}
