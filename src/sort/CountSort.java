package sort;

public class CountSort {

  public static void main(String[] args) {
    //量大，范围小。已经明确了范围：0～10,不用通过比较，也能对元素进行排序
    int[] arr = {3,2,2,3,3,1,1,1,0,0,7,5,6,4,1,2,9,7,0,5,8,1,10};// 11
    sort(arr, 11);

    int[] arr1 = {100,101,129,110,150,144,133,123,144, 149,132,133,145};
    sort2(arr1, 51, 100);

    sort3(arr1);
  }

  static void sort(int[] arr, int k) {
    int[] bucket = new int[k];
    for (int i = 0; i < arr.length; i++) {
      ++bucket[arr[i]];
    }
    ArrUtil.printArr(bucket);
    int[] res = new int[arr.length];
    int index = 0;
    for (int i = 0; i < bucket.length; i++) {
      //i = 0 count=3 index=0 res: 0 0 0
      //i = 1 count=5 index=3 res: 0 0 0 1 1 1 1 1
      //i = 2 count=3 index=8 res: 0 0 0 1 1 1 1 1 2 2 2
      int count = bucket[i];
      for (int j = index; j < count+index; j++) {
        res[j] = i;
      }
      index += count;
    }
    ArrUtil.printArr(res);
  }

  static void sort2(int[] arr, int k, int h) {
    int[] bucket = new int[k];
    for (int i = 0; i < arr.length; i++) {
      ++bucket[arr[i]-h];
    }
    ArrUtil.printArr(bucket);
    int[] res = new int[arr.length];
    int index = 0;
    for (int i = 0; i < bucket.length; i++) {
      //i = 0 count=3 index=0 res: 0 0 0
      //i = 1 count=5 index=3 res: 0 0 0 1 1 1 1 1
      //i = 2 count=3 index=8 res: 0 0 0 1 1 1 1 1 2 2 2
      int count = bucket[i];
      for (int j = index; j < count+index; j++) {
        res[j] = i+h;
      }
      index += count;
    }
    ArrUtil.printArr(res);
  }


  static void sort3(int[] arr) {
    int min = arr[0];
    int max = arr[0];
    for (int i = 0; i < arr.length; i++) {
      min = arr[i] < min ? arr[i] : min;
      max = arr[i] > max ? arr[i] : max;
    }
    int k = max-min+1;
    int h = min;
    int[] bucket = new int[k];
    for (int i = 0; i < arr.length; i++) {
      ++bucket[arr[i]-h];
    }
    ArrUtil.printArr(bucket);
    int[] res = new int[arr.length];
    int index = 0;
    for (int i = 0; i < bucket.length; i++) {
      //i = 0 count=3 index=0 res: 0 0 0
      //i = 1 count=5 index=3 res: 0 0 0 1 1 1 1 1
      //i = 2 count=3 index=8 res: 0 0 0 1 1 1 1 1 2 2 2
      int count = bucket[i];
      for (int j = index; j < count+index; j++) {
        res[j] = i+h;
      }
      index += count;
    }
    ArrUtil.printArr(res);
  }
}
