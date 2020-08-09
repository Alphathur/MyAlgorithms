package sort;

public class MergeSort {


  public static void main(String[] args) {
//    int[] arr = {1,4,6,8,2,3,7};
//    merge2(arr);

//    int[] arr1 = {1,4,5,7,9,0,1,3,5,6,7};
//    merge2(arr1,1,5,8);

    int[] arr2 = {1,4,3,7,6,0,8,3,2,6,7};
//    merge2(arr2,1,5,8);

    sort(arr2, 0, arr2.length-1);
    ArrUtil.printArr(arr2);
  }

  private static void sort(int[] arr, int left, int right) {
    if (left == right) {
      return;
    }
    int mid =  left + (right-left)/2;
    sort(arr, left, mid);
    sort(arr, mid+1, right);
    merge2(arr, left, mid+1, right);
  }

  /**
   * arr = [1 4 6 8 2 3 7]
   * -->1 4 6 8 | 2 3 7
   * -->[  ...        ]
   * -->merge...
   * -->arr[0], arr[4]; arr[1],arr[4]; arr[1],arr[5]...
   * -->[1,2,3,4,6,7,8]
   * @param arr
   */
  private static void merge(int[] arr) {
    int i = 0;
    int mid = arr.length/2;
    int j = mid+1;

    int[] temp = new int[arr.length];
    int k = 0;
    while (i <= mid && j <= arr.length-1) {
      if (arr[i] <= arr[j]) {
        temp[k] = arr[i];
        i++;
        k++;
      }else {
        temp[k] = arr[j];
        j++;
        k++;
      }
    }

    while (i <= mid) {
      temp[k] = arr[i];
      i++;
      k++;
    }
    while (j <=arr.length-1) {
      temp[k] = arr[j];
      j++;
      k++;
    }
    ArrUtil.printArr(temp);
  }

  private static void merge2(int[] arr) {
    int i = 0;
    int mid = arr.length/2;
    int j = mid+1;

    int[] temp = new int[arr.length];
    int k = 0;
    while (i <= mid && j <= arr.length-1) {
      if (arr[i] <= arr[j]) {
        temp[k++] = arr[i++];
      }else {
        temp[k++] = arr[j++];
      }
    }

    while (i <= mid) {
      temp[k++] = arr[i++];
    }
    while (j <=arr.length-1) {
      temp[k++] = arr[j++];
    }
    ArrUtil.printArr(temp);
  }

  private static void merge2(int[] arr, int leftPtr, int rightPrt, int rightBounds) {
    int i = leftPtr;
    int mid = rightPrt-1;
    int j = mid+1;

    int[] temp = new int[rightBounds-leftPtr+1];
    int k = 0;
    while (i <= mid && j <= rightBounds) {
      if (arr[i] <= arr[j]) {
        temp[k++] = arr[i++];
      }else {
        temp[k++] = arr[j++];
      }
    }

    while (i <= mid) {
      temp[k++] = arr[i++];
    }
    while (j <=rightBounds) {
      temp[k++] = arr[j++];
    }
    for (int m = 0; m < temp.length; m++) {
      arr[leftPtr+m] = temp[m];
    }
  }
}
