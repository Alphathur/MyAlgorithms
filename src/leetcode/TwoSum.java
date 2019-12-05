package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9 所以返回 [0, 1]
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/two-sum 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 小结：通常差用HashMap和暴力循环都能解决问题。建议使用HashMap。所有方法都要及时return结果。
 */
public class TwoSum {

  public static void main(String[] args) {

    int[] nums = new int[]{3,2,4};
    int[] results = twoSum(nums, 6);
    System.out.println(Arrays.toString(results));

    int[] results2 = twoSum2(nums, 6);
    System.out.println(Arrays.toString(results2));
  }

  /**
   * 效率最高方案，最多循环n次
   *
   * 使用map，(k,v)分别存放原始数组的值和对应下标，遍历原始数组，求target和当前元素的差值， 以差值作为map的key，查看map的是否包含key对应的元素。
   * 如有，则返回map中key对应的元素和此时的数组下标. 若无，则以当前元素值作为key，当前元素下标作为value存入map，继续循环。
   *
   * 第一次循环，map为空，比较 key = 9-2 是否存在，不存在，put （2，0）到map
   * 第二次循环，map非空，比较 key = 9-7 是否存在，恰好存在，则resuts[0] = map.get(key) = 0, results[i] = 1, 并返回结果。
   *
   * 注意点：
   * 1）map存放的是原数组的值和原数组下标。
   * 2）map每次比较时是通过[target-当前元素的差]来判断是否包含此key。
   */
  public static int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();//(2,0)(7,1),(11,2),(15,3)
    int[] results = new int[2];
    for (int i = 0; i < nums.length; i++) {
      int diff = target - nums[i]; //diff : 7,2,-2,-6
      if (map.get(diff) != null) {
        results[0] = map.get(diff);
        results[1] = i;
        return results;
      }
      map.put(nums[i], i);
    }
    return results;
  }

  /**
   *
   * 暴力循环法。最多可能循环 n^2 次。
   * @param nums
   * @param target
   * @return
   */
  public static int[] twoSum2(int[] nums, int target) { //[3,2,4] 6 --> [1,2]
    int[] results = new int[2];
    for (int i = 0; i < nums.length; i++) {
      for (int j = i+1; j < nums.length; j++) {
        if(nums[j] + nums[i] == target && i != j) { //i != j 是重点，易忽略。
          results[0] = i;
          results[1] = j;
          return results;
        }
      }
    }
    return results;
  }
}
