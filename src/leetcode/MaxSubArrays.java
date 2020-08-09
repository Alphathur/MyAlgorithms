package leetcode;

import java.util.Arrays;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxSubArrays {

  public static void main(String[] args) {
    int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
    int[] arr1 = {1};
    int[] arr2 = {-2, 1};
    System.out.println(maxSubArrays1(arr));
    System.out.println(maxSubArrays3(arr));
  }

  /**
   * 方案一：两层遍历，暴力搜索
   * @param arr
   * @return
   */
  public static int maxSubArrays(int[] arr) {
    int[] res = new int[arr.length];
    int max = arr[0];
    for (int i = 0; i < arr.length; i++) {
      res[i] = arr[i];
      for (int j = i+1; j < arr.length; j++) {
          res[j] = res[j-1]+arr[j];
          if (res[j] > max) {
            max = res[j];
          }
      }
      if (res[i] > max) {
        max =res[i];
      }
    }
    return max;
  }


  /**
   * 方案一：动态规划，建立一个数组存储每次求和的结果
   * 每次判断上次计算的和是否大于0，如果是则当前数组的值加上上次的和即为当前的和，否则设置当前子数组和即为当前坐标数组的值
   * [-2, 1,-3, 4,-1, 2, 1, -5, 4]
   * ==>
   * [-2, 0, 0, 0, 0, 0, 0,  0, 0]
   * ==> -2<0, res[1] = arr[1]
   * [-2, 1, 0, 0, 0, 0, 0,  0, 0]
   * ==> 1>0, res[2] = arr[2]+res[1]
   * [-2, 1, -2, 0, 0, 0, 0,  0, 0]
   * ==> -2<0, res[3] = arr[3]
   * [-2, 1, -2, 4, 0, 0, 0,  0, 0]
   * ==> 4>0, res[4] = arr[4]+res[3]
   * [-2, 1, -2, 4, 3, 0, 0,  0, 0]
   * ==> 3>0, res[5] = arr[5]+res[4]
   * [-2, 1, -2, 4, 3, 5, 0,  0, 0]
   * ...
   * [-2, 1, -2, 4, 3, 5, 6,  0, 0]
   * [-2, 1, -2, 4, 3, 5, 6,  1, 0]
   * [-2, 1, -2, 4, 3, 5, 6,  1, 5]
   * 使用一个指针遍历数组, 得到状态转移方程：
   * dp[i] = max{dp[i-1]+ arr[i], arr[i]}
   * @param arr
   * @return
   */
  public static int maxSubArrays1(int[] arr) {
    int[] res = new int[arr.length];
    res[0] = arr[0];
    int max = res[0];
    for (int i = 1; i < arr.length; i++) {
      if (res[i - 1] > 0) {
        res[i] = res[i - 1] + arr[i];
      } else {
        res[i] = arr[i];
      }
      if (res[i] > max) {
        max = res[i];
      }
    }
    System.out.println(Arrays.toString(res));
    return max;
  }

  /**
   * 方案一：动态规划优化版，去掉存储子数组和的数组，直接覆盖原数组，会改变原始数组的结构
   * [-2,1,-3,4,-1,2,1,-5,4]
   * 使用一个指针遍历数组
   * @param arr
   * @return
   */
  public static int maxSubArrays2(int[] arr) {
    int max = arr[0];
    for (int i = 1; i < arr.length; i++) {
      if (arr[i - 1] > 0) {
        arr[i] = arr[i - 1] + arr[i];
      }
      if (arr[i] > max) {
        max = arr[i];
      }
    }
    System.out.println(Arrays.toString(arr));
    return max;
  }

  /**
   * 使用贪心算法，从左向右遍历数组，如果遍历的和小于0，则重新寻找子串
   * [-2,1,-3,4,-1,2,1,-5,4]
   * sum = 0, max = -2
   * i = -2: sum = 0, max = -2, sum = 0
   * i = 1,  sum = 1, max = 1
   * i = -3, sum = -2, max = 1, sum = 0
   * i = 4,  sum = 4, max = 4
   * i = -1, sum = 3, max = 4
   * i = 2,  sum = 5, max = 5
   * i = 1,  sum = 6, max = 6
   * i = -5, sum = 1, max = 6
   * i = 4, sum = 5,  max = 6
   *
   *
   * sum =
   * @param arr
   * @return
   */
  public static int maxSubArrays3(int[] arr) {
    int max = arr[0];
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
      if (sum > max) {
        max = sum;
      }
      if (sum < 0) {
        sum = 0;
      }
      System.out.println(max);
    }
    System.out.println(Arrays.toString(arr));
    return max;
  }

}
