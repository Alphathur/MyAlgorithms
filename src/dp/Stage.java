package dp;

/**
 * 一只兔子，每次只能跳1个或者3个台阶，假设有n个台阶，那么这只兔子到达最上层台阶共有多少种跳法？
 * 典型的动态规划问题：
 * 假设台阶数设为n，走法数量为k：
 * n = 1	k = 1（1）
 * n = 2	k = 1（1+1）
 * n = 3	k = 2（1+1+1，3）
 * n = 4	k = 3（1+1+1+1，1+3，3+1）
 * n = 5	k = 4（1+1+1+1+1，1+1+3，1+3+1，3+1+1）
 *
 * 显然，根据第一步跳法不同，可以总结出规律：
 * 第一步跳1阶，剩下n-1阶的跳法为m，第二步跳3阶，剩下n-3阶的跳法为n。m+n即为n个台阶的总跳法数。
 * 以上括号中也说明了确实是m+n这个关系！
 * 即: f(n) = f(n-1)+f(n-3)
 *
 */
public class Stage {

  public static void main(String[] args) {
    System.out.println(stage(50));
  }

  private static int stage(int n) {
    int[] res =  new int[n];
    res[0] = 1;
    res[1] = 1;
    res[2] = 2;
    for (int i = 3; i < n; i++) {
      res[i] = res[i-1] + res[i-3];
    }
    return res[n-1];
  }
}
