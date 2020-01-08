package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LengthOfLongestSubstring {

  public static void main(String[] args) {

//    System.out.println(result);
//    System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("")); //0
//    System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring(" ")); //1
//    System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("  "));//1
    System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring2("abccd"));//1
    System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring2("abcbc"));//1

  }


  /**
   * 方案一，暴力搜索子字符串，不断比较来获取最长子字符串的长度。
   * @param s
   * @return
   */
  public int lengthOfLongestSubstring(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    if (s.length() > 0 && s.trim().length() == 0) {
      return 1;
    }
    int result = 1;
    for (int i = 0; i < s.length()-1; i++) {
      for (int j = i+1; j <= s.length(); j++) {
        String str = s.substring(i, j);
        Set<String> filter = new HashSet<>();
        boolean breakFlag = false;
        for (int k = 0; k < str.length(); k++) {
          String cha = str.substring(k, k+1);
          boolean duplicated = filter.add(cha);
          if (!duplicated) {
            breakFlag = !duplicated;
            break;
          }
        }
        if (breakFlag) {
          break;
        }
        if (filter.size() == str.length() && result < str.length()) { //非重复字符的字符串
          result = str.length();
        }
      }
    }
    return result;
  }

  /**
   * 方案二 滑动窗口
   * 设置两个指针 i,j.起始i=0,向右滑动j，将j对应的字符放入到Set中，如果放入Set时不重复，说明这个子串不重复，length就是i，j之间的长度
   * 如果放入Set时重复，那么停止滑动j，将i向右滑动，从Set中移除i对应的字符，再次判断j对应的字符是否在Set中重复
   * 如此往复循环即可。
   *
   * s = "abccd"
   * [a]
   * [a,b]
   * [a,b,c]
   * [b,c]
   * [c]
   * []
   * [c]
   * [c,d]
   *
   * s = "abcbc"
   * [a]
   * [a,b]
   * [a,b,c]
   * [b,c]
   * [c]
   * [c,b]
   * [b]
   * [b,c]
   * @param s
   * @return
   */
  public int lengthOfLongestSubstring2(String s) {
    int n = s.length();
    Set<Character> set = new HashSet<>();
    int ans = 0, i = 0, j = 0;
    while (i < n && j < n) { //abcabcbb ==》i =0: [a],[a,b],[a,b,c], i = 1:[b,c],[b,c,a],[c,a],[]
      // try to extend the range [i, j]
      if (!set.contains(s.charAt(j))){
        set.add(s.charAt(j++));
        ans = Math.max(ans, j - i);
      } else {
        set.remove(s.charAt(i++));
      }
      System.out.println("i：" + i + ", j:" + j + ", set:" + set);
    }
    return ans;
  }
}
