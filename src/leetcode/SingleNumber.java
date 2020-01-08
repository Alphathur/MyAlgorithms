package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SingleNumber {

  public static void main(String[] args) {
    int[] arr = new int[]{1,2,3,4,4,3,2,1};
    int[] arr1 = new int[]{4,1,2,1,2};
    int[] arr11 = new int[]{4,1,2,3,1,2,4,1,1};
    int[] arr2 = new int[]{1,2,1,2,0};
    int[] arr3 = new int[]{1,2,1,2,0,1,2,3,4};

    int m = 0;
    for (int i = 0; i <= arr.length-1; i++) {
      m = i;
      if (notContained(arr, i)) {
        break;
      }
    }
//    System.out.println(arr[m]);
//    System.out.println(notContained(arr, 0));
//    System.out.println(notContained(arr, 1));
//    System.out.println(notContained(arr, 2));
//    System.out.println(notContained(arr, 3));
//    System.out.println(notContained(arr, 4));
//
//    System.out.println(new SingleNumber().singleNumber2(arr));
    System.out.println(new SingleNumber().singleNumber2(arr));
//    System.out.println(new SingleNumber().singleNumber2(arr2));
//    System.out.println(new SingleNumber().singleNumber2(arr3));

    System.out.println(2^3);
    System.out.println(0^4);
    System.out.println(3^4);
    System.out.println(4^4);
  }

  private static boolean notContained(int[] arr, int curr) {
    for (int i = 0; i <= arr.length-1; i++) {
      if (arr[i] == arr[curr] && curr != i) {//contined
          return false;
      }
    }
    return true;
  }


  public int singleNumber(int[] nums) {
    int m = 0;
    for (int i = 0; i <= nums.length-1; i++) {
      m = i;
      if (notContained(nums, i)) {
        break;
      }
    }
   return nums[m];
  }

  public int singleNumber1(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i <= nums.length-1; i++) {
      map.put(nums[i], map.get(nums[i]) == null ? 1 : map.get(nums[i])+1);
    }
    for (Integer itg : map.keySet()) {
      if (map.get(itg).intValue() == 1) {
        return itg;
      }
    }
    return 0;
  }

  /**
   * 思路：按位异或，相同为0，不同为1，01得1，11得0。
   * 由于两两抵消的原因，异或方案只适用于相同数出现次数为偶数的场景，其它场景均不适用。
   * 0与任何数异或都是该数，相同数异或都是0，不同非0数异或得到新数，新数的每一位上都是对应位异或后的结果。
   * 本质就是按位消元。和加法运算的区别是，加法可能产生进位，但是异或不会。
   * 定义一个中间变量：res
   * 遍历初始数组。
   * 第一次异或，res为第一个元素
   * 第二次异或，res为新的元素，这个元素中每一位都是异或后的，要么为0，要么为1
   * 第三次异或，如果当前
   *
   * @param nums
   * @return
   */
  public int singleNumber2(int[] nums) {
    int res = 0;
    for(int i = 0; i < nums.length; i++){
//      System.out.println("res before:" + res);
      res ^= nums[i];
      System.out.println("after res num[i], its :" + nums[i] + "," + res);
    }
    return res;
  }

}
