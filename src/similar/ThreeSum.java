package similar;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定 [1,2,3,6,7,9] target = 6, 因为1+2+3 = 6， 所以返回[0,1,2]
 */
public class ThreeSum {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(threeSum1(new int[]{2,2,3,6,7,9}, 7)));
  }

  /**
   * 使用HashMap计算3数之和为指定值的元素下标，原理和两数之和类似，但是稍作处理。
   * 1）先遍历原数组，计算差值数组 [1,2,3,6,7,9]  -> [5,4,3,0,-1,-3]
   * 2）遍历差值数组，target为差值数组的各个元素，result[0]为差值数组当前下标。
   * 3）再遍历原数组，起始点为当前target的下标+1 。
   * 4）按照两数之和的计算方法，计算其它两个下标，即为result[1]和result[2]。
   *
   * [2,2,3,6,7,9] 7 -> [5,5,4,1,0,-2]
   *
   * @param nums
   * @param target
   * @return
   */
  public static int[] threeSum(int[] nums, int target) {
    int[] temp = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      temp[i] = target - nums[i];
    }
    int[] result = new int[3];
    for (int i = 0; i < temp.length; i++) {
      target = temp[i];
      result[0] = i;
      Map<Integer, Integer> map = new HashMap<>();
      for (int j = i + 1; j < nums.length; j++) {
        int diff = target - nums[j];
        if (map.get(diff) != null) {
          result[1] = map.get(diff);
          result[2] = j;
          return result;
        }
        map.put(nums[j], j);
      }
    }
    return result;
  }

  /**
   * 暴力循环法，三层循环，要注意下标不能重复。
   * @param nums
   * @param target
   * @return
   */
  public static int[] threeSum1(int[] nums, int target) {
    int[] result = new int[3];
    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < nums.length; j++) {
        for (int k = 0; k < nums.length; k++) {
          if (nums[i] + nums[j] + nums[k] == target && i != j && j != k && i != k) {
            result[0] = i;
            result[1] = j;
            result[2] = k;
            return result;
          }
        }
      }
    }
    return result;
  }
}
