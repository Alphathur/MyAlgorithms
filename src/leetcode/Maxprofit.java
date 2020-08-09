package leetcode;

import java.util.Arrays;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意：你不能在买入股票前卖出股票。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Maxprofit {

  public static void main(String[] args) {
    int[] arr = {7,1,5,3,6,4};
    System.out.println(maxProfit(arr));
    int[] arr1 = {7,6,4,3,1};
    System.out.println(maxProfit(arr1));
  }

  /**
   * 动态规划:前i天的最大收益 = max{前i-1天的最大收益，第i天的价格-前i-1天中的最小价格}
   * dp[i] = max{dp[i-1], arr[i]-min{arr[i-1]}}
   * @param arr
   * @return
   */
  public static int maxProfit(int[] arr) {
    if (arr.length == 0) {
      return 0;
    }
    int[] dp = new int[arr.length];
    int min = arr[0];
    dp[0] = 0;
    int max = dp[0];
    for (int i = 1; i < arr.length; i++) {
        min  = arr[i] < min ? arr[i] : min;
        int minp = arr[i] - min;
        dp[i] = dp[i-1] > minp ? dp[i-1] : minp;
        max = dp[i] > max ? dp[i] : max;
    }
    System.out.println(Arrays.toString(dp));
    return max;
  }
}
