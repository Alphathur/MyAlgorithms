package sort;

import java.util.Arrays;

public class QuickSort {


  public static void main(String[] args) {
//    int[] arr = {3,6,4,1,2,9,0,7,5,8,6};

    int[] arr = {7,3,2,10,8,1,9,5,4,6};

    sort(arr, 0, arr.length-1);
    System.out.println(" --- ");
    ArrUtil.printArr(arr);
    partition(arr, 0, arr.length-1);

    System.out.println(" === ");
    ArrUtil.printArr(arr);

//    test1();

//    int[] topK = getLeastMinNumbers(arr, 4);
//    System.out.println(Arrays.toString(topK));

  }


  public static int[] getLeastMinNumbers(int[] arr, int k) {
    if (k == 0 || arr.length == 0) {
      return new int[0];
    }
    // 最后一个参数表示我们要找的是下标为k-1的数
    return quickMinTopSearch(arr, 0, arr.length - 1, k - 1);
  }

  private static int[] quickMinTopSearch(int[] nums, int lo, int hi, int k) {
    // 每快排切分1次，找到排序后下标为j的元素，如果j恰好等于k就返回j以及j左边所有的数；
    int j = partition(nums, lo, hi);
    if (j == k) {
      return Arrays.copyOf(nums, j + 1);
    }
    // 否则根据下标j与k的大小关系来决定继续切分左段还是右段。
    return j > k? quickMinTopSearch(nums, lo, j - 1, k): quickMinTopSearch(nums, j + 1, hi, k);
  }



  static void sort(int[] arr, int leftBound, int rightBound) {
    if (leftBound >= rightBound) {
      return;
    }
    int newBound = partition(arr, leftBound, rightBound);
    sort(arr, leftBound, newBound - 1);
    sort(arr, newBound + 1, rightBound);
  }

  static int partition(int[] arr, int leftBound, int rightBound) {
    int pivot = arr[rightBound];
    int left = leftBound;
    int right = rightBound - 1;
    while (left < right) {
      while (left <= right && arr[left] <= pivot) {
        left++;
      }
      while (left <= right && arr[right] > pivot) {
        right--;
      }
      if (left < right) {
        ArrUtil.swap(arr, left, right);
      }
    }
    if (arr[left] > arr[rightBound]) {
      ArrUtil.swap(arr, left, rightBound);
    }
    ArrUtil.printArr(arr);
    return left;
  }

}
