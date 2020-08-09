package sort;

public class BubbleSort {

  public static void main(String[] args) {
    int[] arr = {3,6,4,1,2,9,7,0,5,8,1};// 11
    sort2(arr);
    ArrUtil.printArr(arr);
  }


  static void sort(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
      for (int j = 0; j < arr.length - 1 - i; j++) {
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    }
  }

  static void sort2(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
      int flag = 0;
      for (int j = 0; j < arr.length - 1 - i; j++) {
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
          flag = 1;
        }
      }
      if (flag == 0) {
        return;
      }
    }
  }

}
