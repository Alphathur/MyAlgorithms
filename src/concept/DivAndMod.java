package concept;

/**
 * 理解取模运算和整除运算的区别：
 *
 * java取模运算 % 就是取余运算。
 * java的整除运算 / 是针对整数之间的除法运算，商只保留整数。
 * 例如 9 % 4 = 1， 9 / 4 = 2。
 *
 * 另外对10整除和对10取模有非常重要的意义。
 * Modding (%) the input int by 10 will extract off the rightmost digit. example: (1234 % 10) = 4
 * Dividing an integer by 10 will remove the rightmost digit. (75 / 10) = 7
 * 简单来说，整数对10取模就能获取该整数最右边的1个整数。整数对10取整便会截掉最右边的1个整数。
 * 区别就是：对10取模是获取最右边的数，对10取整是截掉最右边的数获取左边的数。
 *
 * 例如：9876 % 10 = 6， 9876 / 10 = 987
 *       987 % 10 = 7，  987 / 10 = 98，
 *        98 % 10 = 8，   98 / 10 = 9
 *         8 % 10 = 8，    9 / 10 = 0
 * 拓展：
 * 如果取模和取整的操作数是10的指数结果，则指数的值就代表要获取或截断的位数。
 * 如 9876 % 100 = 7， 9876 / 100 = 98
 * 对100取余则从整数的最右边开始获取2个整数，对100取整则从整数的最右边开始截掉2个整数
 *
 * 理解取模运算和整除运算的区别将有助于快速计算。
 */
public class DivAndMod {

  public static void main(String[] args) {
    System.out.println(8%10);
    System.out.println(9/10);
  }

}
