package leetcode;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 *
 * 你能不将整数转为字符串来解决这个问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ParelindRome {


  public static void main(String[] args) {
    System.out.println(new ParelindRome().isPalindrome(1000000001));
    System.out.println(new ParelindRome().isPalindrome2(1000000001));
    System.out.println(new ParelindRome().isPalindrome2(100000001));
    System.out.println(new ParelindRome().isPalindrome2(1234321));
  }

  /**
   * 方案一：计算输入数字的翻转数字，然后比较是否相等即可，注意数值溢出的情况。
   * @param x
   * @return
   */
  public boolean isPalindrome(int x) {
    if (x < 0) {
      return false;
    }
    long longX = x;
    long reverseX = 0;
    while (longX != 0) {
      reverseX = reverseX * 10 + longX % 10;
      longX = longX / 10;
    }
    return reverseX == x;
  }

  /**
   * 方案二：基于方案二的优化版本，仅当O于翻转数值时才计算翻转数值，相当于只计算一半的对折数，然后拿对折数和原始数字的左半部分进行比较，相等即可。
   * 注意，由于输入数字可能是偶数也可能是奇数，当输入数字是偶数时，对折数和原始数字左半部分位数一致，可以直接比较。如果是奇数，需要将对折数先对10取模，然后
   * @param x
   * @return
   */
  public boolean isPalindrome2(int x) {
    if (x < 0 || (x != 0 && x / 10 == 0)) {
      return false;
    }
    long reverseX = 0;
    while (x > reverseX) {
      reverseX = reverseX * 10 + x % 10;
      x = x / 10;
    }
    return reverseX == x || x == reverseX / 10;
  }
}
