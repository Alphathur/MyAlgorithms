package sort;

import java.util.Arrays;

/**
 * 给定长度为m的字符串aim，以及一个长度为n的字符串str，能否在str中找到长度为m的一个子串，使得子串刚好由aim包含的字符串组成。找到即返回子串的起始位置，未找到返回-1
 * 例如:
 * str：helloword, aim: eow, ==> -1
 * str：helloword, aim: word, ==> 5
 * str：helloword, aim: row, ==> 5
 */
public class StrFinder {

  public static void main(String[] args) {

    int index = find2("helloword", "eow");
    int index1 = find2("helloword", "word");
    int index2 = find2("helloword", "row");
    System.out.println(index);
    System.out.println(index1);
    System.out.println(index2);
  }


  /**
   * 滑动窗户，窗口长度固定为aim的长度，从左向右依次滑动，并判断即可。
   * @param str
   * @param aim
   * @return
   */
  static int find(String str, String aim) {
    if (aim == null || aim.length() == 0 || aim.length() > str.length()) {
      return -1;
    }
    int length = aim.length();
    int end = str.length()-length+1;
    for (int i = 0; i < end; i++) {
      String sub = str.substring(i, i+length);
      if (equalsAny(sub, aim)) {
        return i;
      }
    }
    return -1;
  }

  /**
   * "45321","32"
   * [4,5,3,2,1]
   * [3,2]
   *
   * [4,5,3,3,1]
   * [3,1]
   * @param str
   * @param aim
   * @return
   */
  static int find2(String str, String aim) {
    if (aim == null || aim.length() == 0 || aim.length() > str.length()) {
      return -1;
    }
    char[] strArr = str.toCharArray();
    char[] aimArr = aim.toCharArray();
    for (int i = 0, j = aimArr.length-1; i < (strArr.length - aimArr.length+1) && j < strArr.length; i++, j++) {
      if (arrEuqal(strArr, i, j, aimArr)) {
        return i;
      }
    }
    return -1;
  }


  static boolean arrEuqal(char[] arr, int start, int end, char[] aim) {
    char[] count = new char[256];
    for (int i = start; i < end+1; i++) {
      count[arr[i]]++;
    }
    char[] count2 = new char[256];
    for (int i = 0; i < aim.length; i++) {
      count2[aim[i]]++;
    }
    for (int i = 0; i < count.length; i++) {
      if (count[i] != count2[i]) {
        return false;
      }
    }
    return true;
  }

  static boolean equalsAny(String str1, String str2) {
    char[] chars1 = str1.toCharArray();
    char[] chars2 = str2.toCharArray();
    Arrays.sort(chars1);
    Arrays.sort(chars2);
    for (int i = 0; i < chars1.length; i++) {
      if (chars1[i] != chars2[i]) {
        return false;
      }
    }
    return true;
  }
}
