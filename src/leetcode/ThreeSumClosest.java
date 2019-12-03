package leetcode;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 *
 * [0,2,1,-3]
 * 1
 * ==》 0
 *
 * [4,0,5,-5,3,3,0,-4,-5]
 * -2
 * ==》 -2
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeSumClosest {

  public static void main(String[] args) {
    ThreeSumClosest obj = new ThreeSumClosest();
    int i = obj.threeSumClosest(new int[]{4,0,5,-5,3,3,0,-4,-5}, -2);
    System.out.println(i);
    int i2 = obj.threeSumClosest(new int[]{0,2,1,-3}, 1);
    System.out.println(i2);

    int i3 = obj.threeSumClosest2(new int[]{4,0,5,-5,3,3,0,-4,-5}, -2);
    System.out.println(i3);
    int i4 = obj.threeSumClosest2(new int[]{0,2,1,-3}, 1);
    System.out.println(i4);
  }

  /**
   * 思路：类似于三数之和，遍历输入数组，建立一个TreeMap(可自动排序)，key:【和与target之差绝对值】，value:【和】 取第一个元素即可。
   * @param nums
   * @param target
   * @return
   */
  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);

    TreeMap<Integer, Integer> diffMap = new TreeMap<>(); //key:和与target之差的绝对值，value:和

    for (int i = 0 ; i < nums.length - 2; i++) {
      int j = i+1;
      int k = nums.length-1;
      while (j < k) {
        int sum = nums[i] + nums[j] + nums[k];
        if (sum < target) {
          j++;
          diffMap.put(target-sum, sum);
        } else if (sum > target) {
          k--;
          diffMap.put(sum-target, sum);
        } else {
          return sum;
        }
      }
    }
    return diffMap.get(diffMap.firstKey());
  }

  /**
   * 方案二：
   * 由于TreeMap本质是用来获取和最接近的元素，所以可以使用一个全局变量存放最接近的元素，每次循环时进行比较赋值即可，避免浪费空间。
   * @param nums
   * @param target
   * @return
   */
  public int threeSumClosest2(int[] nums, int target) {
    Arrays.sort(nums);

    int result = nums[0]+nums[1]+nums[2];

    for (int i = 0 ; i < nums.length - 2; i++) {
      int j = i+1;
      int k = nums.length-1;
      while (j < k) {
        int sum = nums[i] + nums[j] + nums[k];
        if (Math.abs(sum-target) < Math.abs(result-target)) {
          result=sum;
        }
        if (sum < target) {
          j++;

        } else if (sum > target) {
          k--;

        } else {
          return sum;
        }
      }
    }
    return result;
  }

}
