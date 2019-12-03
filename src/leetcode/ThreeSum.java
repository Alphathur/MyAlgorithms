package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeSum {

  public static void main(String[] args) {
    System.out.println(threeSum(new int[]{-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0}));
  }

  /**
   * 思路：先排序，然后移动左右指针，相加和为指定值则放进数组，同时通过预定左右指针来去重
   */
  public static List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    //step1 sort origin array
    Arrays.sort(nums);
    //step2 for each loop
    for (int i = 0; i < nums.length - 2; i++) { // i:start pointer of array
      if (nums[i] > 0) {
        break;
      }
      if (i > 0 && nums[i - 1] == nums[i]) {
        continue;
      }
      int j = i + 1; //j:second pointer of array initialized with value bigger than start pointer
      int k = nums.length - 1; //k:third pointer of array initialized with end index of array
      while (j < k) {
        int sum = nums[i] + nums[j] + nums[k];
        if (sum < 0) { //move j behind
          j++; //each moved value should be used to calculate sum value
        } else if (sum > 0) { //move k forward
          k--;
        } else {
          result.add(Arrays.asList(nums[i], nums[j], nums[k]));
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
    return result;
  }
}
