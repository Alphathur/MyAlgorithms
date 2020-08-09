package leetcode;

/**
 * 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
 *
 * 示例1:
 *
 *  输入：n = 3
 *  输出：4
 *  说明: 有四种走法
 * 示例2:
 *
 *  输入：n = 5
 *  输出：13
 * 提示:
 *
 * n范围在[1, 1000000]之间
 * 通过次数6,491提交次数18,851
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/three-steps-problem-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class StepWays {

  public static void main(String[] args) {
    System.out.println(waysToStep1(16));
    System.out.println(waysToStep1(26));
    System.out.println(waysToStep(16));
    System.out.println(waysToStep(26));
  }

  /**
   * n=1 1
   * n=2 2
   * n=3 4
   * n=4 7
   * n=5 13
   * n=6 24
   * ....
   * 本质还是个递归的过程
   * 方案一：采用递归解法
   * 时间复杂度太高了：O(2^n)
   * @param n
   * @return
   */
  public static int waysToStep1(int n) {
    if (n == 1) {
      return 1;
    }
    if (n == 2) {
      return 2;
    }
    if (n == 3) {
      return 4;
    }
    return waysToStep(n-1)+waysToStep(n-2)+waysToStep(n-3);
  }

  /**
   * 动态规范方案，不用递归
   */
  final static int mod = 1000000007;
  public static int waysToStep(int n) {
    switch (n){
      case 1:
        return 1;
      case 2:
        return 2;
      case 3:
        return 4;
      default:
        break;
    }
    int[] result = new int[n];
    result[0] = 1; //走1个台阶，1种走法
    result[1] = 2; //走2个台阶，2种走法
    result[2] = 4; //走3个台阶，4种走法

    for (int i = 3; i < n; i++){
      result[i] = ((result[i-3]%mod + result[i-2]%mod)%mod + result[i-1]%mod)%mod;
//      result[i] = result[i-3]+ result[i-2] + result[i-1];
    }
    return result[n-1];
  }
}
