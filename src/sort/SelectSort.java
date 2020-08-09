package sort;

public class SelectSort {


  public static void main(String[] args) {
    int[] arr = {3,6,4,1,2,9,7,0,5,8,1};// 11
    sort(arr);
    printArr(arr);

    /**
     *
     * swap(arr, 0, 7)
     * swap(arr, 10, 5)
     *
     * swap(arr, 1, 3)
     * swap(arr, 9, 9)
     *
     * swap(arr, 2, 3)
     * swap(arr, 9, 9)
     *
     */

  }
  private static void sort(int[] arr){
    for (int i = 0; i < arr.length - 1; i++) {
      int minPos = i;
      for (int j = i+1; j < arr.length; j++) {
        minPos = arr[j] < arr[minPos] ? j : minPos;
      }
      if (i != minPos) {
        int temp = arr[i];
        arr[i] = arr[minPos];
        arr[minPos] = temp;
      }
    }
  }

  private static void sort2(int[] arr){
    for (int i = 0; i < arr.length/2; i++) {
      int minPos = i;
      int currMax = arr.length-i-1;
      int maxPos = currMax;

      for (int j = i+1; j < arr.length-i; j++) {
        minPos = arr[j] < arr[minPos] ? j : minPos;
        maxPos = arr[j] > arr[maxPos] ? j : maxPos;
//        System.out.println("i :" + i+ " minPos:"+ minPos);
      }
      if (i != minPos) {
        System.out.println("swap min ,i :" + i + " , minPos : "+minPos);
        swap(arr, i, minPos);
      }

      if (currMax != maxPos) {
        System.out.println("swap max ,curr :" + currMax + " , maxPos : "+maxPos);
        swap(arr, currMax, maxPos);
      }
    }
  }

  private static void printArr(int[] arr) {
    for (int i = 0;  i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
  }

  private static void swap(int[] arr, int i, int minPos) {
    int temp = arr[i];
    arr[i] = arr[minPos];
    arr[minPos] = temp;
  }

}
