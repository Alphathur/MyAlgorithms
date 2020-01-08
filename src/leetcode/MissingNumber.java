package leetcode;

import java.util.Arrays;

/**
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 *
 * 示例 1:
 *
 * 输入: [3,0,1]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 * 说明:
 * 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/missing-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MissingNumber {

  public static void main(String[] args) {
    System.out.println(new MissingNumber().missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
    System.out.println(new MissingNumber().missingNumber(new int[]{0,1,3,4}));
    System.out.println(new MissingNumber().missingNumber(new int[]{0,4,5,3,1}));
    System.out.println(new MissingNumber().missingNumber2(new int[]{0,1,2,3}));
    System.out.println(2^4^5);
  }

  public int missingNumber(int[] nums) {
    Arrays.sort(nums);
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != i) {
        return i;
      }
    }
    return nums[nums.length-1] + 1;
  }

  /**
   * 使用位运算异或，由于位运算异或操作满足乘法交换律，所以将每个元素的下标和该下标对应的值进行异或。
   * 由于两两相同，异或得0，所以满足条件的数就能和该数对应的下标消掉。剩下的无法消掉的就是需要求的数。
   * 注意：异或的起始值为 nums.length,即[0] ==> 1, [0,1]==》2
   * 例如： 0,1,3,4， 下标  0，1，2，3
   * 那么：4^(0^1^3^4)^(0^1^2^3) ==> 0^0^1^1^2^3^3^4^4 ==> 2
   *
   * @param nums
   * @return
   */
  public int missingNumber2(int[] nums) {
    int res = nums.length;
    for (int i = 0; i < nums.length; i++) {
      res = res^nums[i]^i;
    }
    return res;
  }
}
