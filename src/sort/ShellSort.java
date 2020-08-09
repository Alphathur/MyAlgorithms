package sort;

public class ShellSort {

  public static void main(String[] args) {
    int[] arr = {9,6,11,3,5,12,8,7,10,15,14,4,1,13,2};// 11
    sort2(arr);
    ArrUtil.printArr(arr);
  }


  private static void sort(int[] arr) {
    for (int gap = arr.length/2; gap >0 ; gap /= 2) {
      System.out.println("++++++++++++++++++++++++++gap:" + gap);
      for (int i = gap; i < arr.length; i++) {
        System.out.println("====== i: "+ i);
        for (int j = i; j > gap-1; j-=gap) {
          System.out.println("j:"+ j +", j-gap:" + (j-gap));
          if (arr[j] < arr[j-gap]) {
            ArrUtil.swap(arr, j, j-gap);
          }
        }
      }
    }
  }


  /**
   * Knuth h=1, h=3h+1
   * @param arr
   */
  private static void sort2(int[] arr) {
    int h = 1;
    while (h <= arr.length/3) {
      h = h*3+1;
    }

    for (int gap = h; gap >0 ; gap = (gap-1)/3) {
      System.out.println("++++++++++++++++++++++++++gap:" + gap);
      for (int i = gap; i < arr.length; i++) {
        System.out.println("====== i: "+ i);
        for (int j = i; j > gap-1; j-=gap) {
          System.out.println("j:"+ j +", j-gap:" + (j-gap));
          if (arr[j] < arr[j-gap]) {
            ArrUtil.swap(arr, j, j-gap);
          }
        }
      }
    }
  }

}
