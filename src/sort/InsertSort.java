package sort;

public class InsertSort {

  public static void main(String[] args) {
    int[] arr = {3,6,4,1,2,9,7,0,5,8,1};// 11
    sort(arr);
    ArrUtil.printArr(arr);
  }

  static void sort(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      for (int j = i; j > 0; j--) {
        if (arr[j-1] > arr[j]) {
          int temp = arr[j-1];
          arr[j-1] = arr[j];
          arr[j] = temp;
        }
      }
    }
  }
}
