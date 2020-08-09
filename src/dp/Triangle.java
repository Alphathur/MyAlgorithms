package dp;

import java.util.Arrays;

public class Triangle {

  private static int[][] triangle = {
      {2, 0, 0, 0},
      {3, 4, 0, 0},
      {6, 5, 7, 0},
      {4, 1, 8, 3}
  };

  public static  void main(String[] args) {
    int m = triangle.length-2;
    int n = triangle[0].length-1;
    System.out.println(traverse(m,n));
  }

  private static int traverse(int m, int n) {
    for (int i = m; i >= 0 ; i--) {
      for (int j = 0; j < n; j++) {
        triangle[i][j] = triangle[i][j] + Math.min(triangle[i+1][j], triangle[i+1][j+1]);
      }
    }
    return triangle[0][0];
  }

  private static int traverse3() {
    for (int i = 2; i >= 0 ; i--) {
      for (int j = 0; j < 3; j++) {
        triangle[i][j] = triangle[i][j] + Math.min(triangle[i+1][j], triangle[i+1][j+1]);
      }
    }
    return triangle[0][0];
  }

  private static int traverse() {
    int[] min = triangle[3];
    for (int i = 2; i >= 0 ; i--) {
      System.out.println("===========i:"+ i +"===========");
      for (int j = 0; j < 3; j++) {
        System.out.println("triangle[i][j]: " + triangle[i][j] + " , min[j]: "+ min[j] + " , min[j+1]: " + min[j+1]);
        min[j] = triangle[i][j] + Math.min(min[j], min[j+1]);
        System.out.println(Arrays.toString(min));
      }
    }
    return min[0];
  }

  public static int traverse1() {
    int ROW = 4;
    int[] mini = triangle[ROW - 1];
    // 从倒数第二行求起，因为最后一行的值本身是固定的
    for (int i = ROW - 2; i >= 0; i--) {
      for (int j = 0; j < triangle[j].length-1; j++) {
        mini[j] = triangle[i][j] + Math.min(mini[j], mini[j+1]);
      }
    }
    return mini[0];
  }
}
