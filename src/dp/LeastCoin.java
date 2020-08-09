package dp;

/**
 * 假设有1元，5元，11元这三种面值的硬币，给定一个整数金额，比如15元，最少使用的硬币组合是什么？
 * 思考：设金额为s，硬币数为n，则
 * s = 1	n = 1(1)			  [1,0,0]
 * s = 2	n = 2(1+1)		  [2,0,0]
 * s = 3	n = 3(1+1+1)		[3,0,0]
 * s = 4 	n = 4(1+1+1+1)	[4,0,0]
 * s = 5 	n = 1(5)		  	[0,1,0]
 * s = 6	n = 2(5+1）		  [1,1,0]
 * s = 7	n = 3(5+1+1)	  [2,1,0]
 * s = 8	n = 4(5+1+1+1)	[3,1,0]
 * s = 9	n = 5(5+1+1+1+1)[4,1,0]
 * s = 10	n = 2(5+5)		  [0,2,0]
 * s = 11 n = 1
 *
 */
public class LeastCoin {

  public static void main(String[] args) {
    int[] coin = {1,5,11};
//    System.out.println(leastCoin(coin, 1));
//    System.out.println(leastCoin(coin, 2));
//    System.out.println(leastCoin(coin, 3));
//    System.out.println(leastCoin(coin, 4));
//    System.out.println(leastCoin(coin, 5));
    System.out.println(leastCoin(coin, 6));
    System.out.println(leastCoin(coin, 10));
//    System.out.println(leastCoin(coin, 11));


  }

  /**
   *
   * coin = [1,5,11] , money = 15
   *
   *
   * @param coin
   * @param money
   * @return
   */
  private static int leastCoin(int[] coin, int money) {
    int[] minCoins = new int[money+1];
    if (money <= 0) {
      return 0;
    }
    for (int sum = 1; sum <= money; sum++) {
      int min = sum; // 使用最小面额，需要的硬币数量是最多的，也就是当前的金额总额
      for (int kind = 0; kind < coin.length; kind++) {
        int kindValue = coin[kind]; ////逐渐扩大面额，当面额逐渐扩大，需要的张数越来越少
        if (kindValue <= sum) {
          //当面额依然小于金额总额时，分解总金额：
          //kindValue=1,意味着取最近一次金额的组合加上1，即为当前金额的最小组合数。
          //kindValue=5,意味着取最近五次金额的组合加上1，即为当前金额的最小组合数。
          //kindValue=11,意味着取最近十一次金额的组合加上1，即为当前金额的最小组合数。
          //总结状态转移方程：pd[i] = min{pd(i-1), pd(i-5), pd(i-11)}+1

          //eg；sum=3，即3元比2元多了1元，2元为2种组合，3元的组合为2元组合+1 ...
          //eg；sum=4，即4元比3元多了1元，3元为3种组合，4元的组合为3元组合+1 ...
          //eg；sum=5，即5元比1元多了4元，4元为4种组合，5元的组合为4元组合+1，所以是5种; 但当kindValue=5时，5元比5元多了0元，0元的组合+1为1
          //eg；sum=6，即6元比5元多了1元，1元为1种组合，6元为1元组合+1 ...
          //eg；sum=7，即7元比5元多了2元，2元为2种组合，7元为2元组合+1 ...
          int temp = minCoins[sum - kindValue] + 1;
          if (temp < min) {
            min = temp;
          }
        }
        minCoins[sum] = min;
      }
    }
    return minCoins[money];
  }


}
