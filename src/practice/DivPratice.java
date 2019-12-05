package practice;

import java.util.ArrayList;
import java.util.List;

/**
 * 理解取模运算和取
 */
public class DivPratice {

  public static void main(String[] args) {

    int x = 12345;

    System.out.println("======  %  ==");

    System.out.println(x%10);
    System.out.println(x%100);
    System.out.println(x%1000);
    System.out.println(x%10000);
    System.out.println(x%100000);

    System.out.println("======  /  ==");

    System.out.println(x/10);    //1234
    System.out.println(x/100);   //123
    System.out.println(x/1000);  //12
    System.out.println(x/10000); //1
    System.out.println(x/100000);//0

    System.out.println("--------------------");
    isPalindrome(123321);
    System.out.println("--------------------");

    System.out.println("--------------------");
    isPalindrome(12321);
    System.out.println("--------------------");

    System.out.println("--------------------");
    isPalindrome(12345);
    System.out.println("--------------------");

    System.out.println("***************************");
    System.out.println(reverseNumber(1000000001));
    System.out.println("***************************");
    System.out.println(reverseNumber(1234321));

    System.out.println(x%10);
    System.out.println((x/10)%10);
    System.out.println((x/(10*10))%10);
    System.out.println((x/(10*10*10))%10);
    System.out.println((x/(10*10*10*10))%10);

    int temp = x;
    while (temp != 0) {
      int s = temp % 10;
      temp = temp / 10;
      System.out.println(s);
    }
  }

  private static List<Integer> reversedNumberList(int input) {
    List<Integer> list = new ArrayList<>();
    int temp = input;
    while (temp != 0) {
      int s = temp % 10;
      temp = temp / 10;
      System.out.println(s);
    }

    return list;

  }


  /**
   *   5      x%10
   *   54    (x%10)*10 + (x/10)%10
   *   543   (x%10)*10*10 + (x/(10*10))%10
   *   5432  (x%10)*10*10*10 + (x/(10*10*10))%10
   *   54321 (x%10)*10*10*10*10 + (x/(10*10*10*10))%10
   *
   * @param input
   * @return
   */
  private static int reverseNumber(int input) {
    long inputLong = input;
    long reverseNumber = 0;
    while (inputLong != 0) {
      System.out.println("inputLong:" + inputLong);
      System.out.println("reverseNumber:"+reverseNumber);
      reverseNumber = reverseNumber*10 + inputLong%10;
      inputLong = inputLong/10;

    }
    return (int)reverseNumber;
  }

  public static boolean isPalindrome(int x) {
    //思考：这里大家可以思考一下，为什么末尾为 0 就可以直接返回 false
    if (x < 0 || (x % 10 == 0 && x != 0)) return false;
    int revertedNumber = 0;
    while (x > revertedNumber) {
      revertedNumber = revertedNumber * 10 + x % 10;
      x /= 10;
    }
    return x == revertedNumber || x == revertedNumber / 10;
  }

}
