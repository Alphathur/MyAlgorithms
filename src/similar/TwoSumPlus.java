package similar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 两数之和返回满足所有组合条件的集合，非下标.
 */
public class TwoSumPlus {

  public static void main(String[] args) {
    System.out.println(twoSum(new int[]{-1, 0, 1, 2, -1, -4}, 0));
  }

  public static List<List<Integer>> twoSum(int[] nums, int target) { //[-1, 0, 1, 2, -1, -4]
    List<List<Integer>> list = new ArrayList<>();//
    int[] temp = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      int diff = target - nums[i]; //temp [1, 0, -1, -2, 1, 4]
      temp[i] = diff;
    }
    for (int i = 0; i < temp.length; i++) {
      int tempTarget = temp[i]; //tempTarget = 1, i = 0
      for (int j = i + 1; j < nums.length; j++) {
        for (int k = j + 1; k < nums.length; k++) {
          if (nums[j] + nums[k] == tempTarget) {
            List<Integer> item = Arrays.asList(new Integer[]{nums[i], nums[j], nums[k]});
            Collections.sort(item);
            if (!list.contains(item)) {
              list.add(item);
            }
          }
        }
      }
    }
    return list;
  }
}
