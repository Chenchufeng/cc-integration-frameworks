package chufeng.com.Leetcode;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。 示例 1：
 *
 * <p>输入：s = "We are happy." 输出："We%20are%20happy."
 *
 * <p>限制：0 <= s 的长度 <= 10000
 */
public class ReplaceSpace {
  public static String replaceSpace(String s) {
    StringBuilder sb = new StringBuilder();
    char[] chars = s.toCharArray();
    for (char c : chars) {
      if (c == ' ') {
        sb.append("%20");
      } else {
        sb.append(c);
      }
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    String str = "We are happy";
    // 放法二
    System.out.println(str.replace(" ", "%20"));
    //        System.out.println(replaceSpace(str));
  }
}
