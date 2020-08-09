package leetcode;

import java.util.Arrays;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 问总共有多少条不同的路径？
 *
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class UniquePaths {

  public static void main(String[] args) {
    System.out.println(uniquePath(7,3));
  }

  /**
   * 动态规划问题，pd[i][j] = pd[i-1][j] + pd[i][j-1]
   *
   * m = 3, n = 2
   *  [] []
   *  [] []
   *  [] []
   *
   * 输出3
   * @param m
   * @param n
   * @return
   */
  public static int uniquePath(int m, int n) {
    if (m <= 1 || n <= 1) {
      return 1;
    }
    int[][] pd = new int[m][n];
    pd[1][0] = 1;
    pd[0][1] = 1;
    for (int i = 0; i < m; i++) {
      pd[i][0] = 1;
    }
    for (int j = 0; j < n; j++) {
      pd[0][j] = 1;
    }
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        pd[i][j] = pd[i-1][j] + pd[i][j-1];
      }
    }
    return pd[m-1][n-1];
  }
}
