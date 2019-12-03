package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 *
 * 答案中不可以包含重复的四元组。
 *
 * 示例：
 *
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FourSum {

  //[-1,-5,-5,-3,2,5,0,4]
  //-7
  public static void main(String[] args) {
    System.out.println(fourSum(new int[]{-1,-5,-5,-3,2,5,0,4}, -7));
  }

  /**
   * 原理同三数之和，多增加一个移动指针。
   * 基本思路为，遍历两次数组，最外围遍历的每个元素*(-1)作为sum的目标，最内层的遍历就是为了寻找和为target的三个元素组合。
   * It's basically a transform of 3Sum, The only difference between 3Sum and 4Sum is that in 4Sum each loop may hold a different sum value
   * @param nums
   * @return
   */
  public static List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    System.out.println(Arrays.toString(nums));
    Set<Integer> filter = new HashSet<>();
    for (int i = 0; i < nums.length - 3; i++) { // i:start pointer of array
      if (!filter.add(nums[i])) {
        continue;
      }
      int thrSumTarget = target - nums[i];
      for (int m = i + 1; m < nums.length - 2; m++) {
        if (thrSumTarget >= 0 && nums[m] > thrSumTarget) {
          break;
        }
        if (m > i + 1 && nums[m - 1] == nums[m]) {
          continue;
        }
        int j = m + 1; //j:second pointer of array initialized with value bigger than start pointer
        int k = nums.length - 1; //k:third pointer of array initialized with end index of array
        while (j < k) {
          int sum = nums[m] + nums[j] + nums[k];
          if (sum < thrSumTarget) { //move j behind
            j++; //each moved value should be used to calculate sum value
          } else if (sum > thrSumTarget) { //move k forward
            k--;
          } else {
            List<Integer> item = Arrays.asList(nums[i], nums[m], nums[j], nums[k]);
            result.add(item);
            while (j < k && nums[j] == nums[j
                + 1]) { //remove duplicate value of left array,move j behind
              j++;
            }
            while (j < k && nums[k] == nums[k
                - 1]) { //remove duplicate value of right array,move k forward
              k--;
            }
            j++; //before this line, nums[j] is the last same value compared with num[j-1], so continue move behind is required.
            k--; //before this line, nums[k] is the last same value compared with nums[k-1], so continue move forward is required.
          }
        }
      }
    }
    return result;
  }
}
