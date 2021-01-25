package chufeng.com.JVM;

import java.util.Random;

public class OOMTest {
  public static void main(String[] args) {
    String str = "chenchufeng";
    while (true) {
      str += str + new Random().nextInt(888888888) + new Random(99999999);
    }
  }
}
