package chufeng.com.Thread;

import chufeng.com.Thread.utils.DownloadUtils;

public class TestThread extends Thread{
    private String url;
    private String name;
    public TestThread(String url,String name) {
        this.url=url;
        this.name=name;
    }

    @Override
    public void run() {
        DownloadUtils.downLoadPicture(url,name);
        System.out.println("下载了文件名为:"+name);
    }

    public static void main(String[] args) {
        TestThread t1 = new TestThread("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3795757253,2048194183&fm=26&gp=0.jpg", "a1.jpg");
        TestThread t2 = new TestThread("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2233919607,492292383&fm=26&gp=0.jpg", "a2.jpg");
        TestThread t3 = new TestThread("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2229933833,3823819913&fm=26&gp=0.jpg", "a3.jpg");

        t1.start();
        t2.start();
        t3.start();
    }
}
