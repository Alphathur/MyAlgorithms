package leetcode;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,3,2]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [0,1,0,1,0,1,99]
 * 输出: 99
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SingleNumberII {


  public static void main(String[] args) {
    int[] nums = new int[]{1,3,1,3,1,2,3};
    int res = 0;
    for (int i = 0; i < nums.length; i++) {
      res = res^i;

    }
  }

  /**
   * 输入：[0,2,0,2,0,2,99] ==> 99
   *
   * @param nums
   * @return
   */
  public int singleNumberII(int[] nums) {

    for (int i = 0; i < nums.length; i++) {

    }
    return 0;
  }
}
