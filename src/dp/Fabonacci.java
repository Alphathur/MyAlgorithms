package dp;

public class Fabonacci {

  public static void main(String[] args) {
    long t1 = System.currentTimeMillis();
    System.out.println(fabonacci(40));
    long t2 = System.currentTimeMillis();
    System.out.println(fabonacci2(40));
    long t3 = System.currentTimeMillis();
    System.out.println("fabonacci:" + (t2-t1));
    System.out.println("fabonacci2:" + (t3-t2));
  }

  /**
   * 经典的fabonacci问题，1 1 2 3 5 8 13 21...
   * 使用递归算法实现，本质是一种分治策略，自顶向下。
   * 不断的将大计算拆分成小计算，最后再对小计算的结果进行合并。
   * 递归的缺点是不能复用小计算的结果，导致时间复杂度非常高，本方案时间复杂度O(2^n)，空间复杂度O(1)
   * @param n
   * @return
   */
  private static int fabonacci(int n) {
    if (n==0) {
      return 1;
    }
    if (n==1) {
      return 1;
    }
    return fabonacci(n-1)+fabonacci(n-2);
  }

  /**
   * 使用动态规划优化fabonacci。
   * 不同于递归算法，动态规划的核心是能够复用上次计算的结果。
   * 本题采用动态规范，建立一个数组保存每个fabonacci数列的值，返回某个数列的值通过数组下标直接返回即可。
   * 时间复杂度O(n),空间复杂度O(n)
   * @param n
   * @return
   */
  private static int fabonacci2(int n) {
    if (n==0) {
      return 1;
    }
    if (n==1) {
      return 1;
    }
    int[] res = new int[n+1]; //存储每个可能
    res[0] = 1;
    res[1] = 1;
    for (int i = 2; i < n+1; i++) {
      res[i] = res[i-1]+res[i-2];
    }
    return res[n];
  }

}
