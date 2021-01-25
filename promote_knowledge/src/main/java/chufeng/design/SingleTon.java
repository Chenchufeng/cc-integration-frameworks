package chufeng.design;

public class SingleTon {
  private static SingleTon singleTon = new SingleTon();
  public static int count1;
  public static int count2 = 0;

  private SingleTon() {
    count1++;
    count2++;
  }

  public static SingleTon getInstance() {
    return singleTon;
  }
}

class Test {
  public static void main(String[] args) {
    char ch = '中';
    System.out.println("char:" + ch);
    int max = Character.MAX_VALUE;
    int min = Character.MIN_VALUE;
    System.out.println(min + "<char<" + max);// 0<char<65535
  }
}
