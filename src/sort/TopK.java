package sort;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopK {

  public static void main(String[] args) {
    int[] arr = {3,6,4,1,2,9,7,0,5,8,1};// 11
    int[] topk = getLeastNumbers(arr, 3);
    System.out.println(Arrays.toString(topk));
    int[] topk2 = getLeastNumbers2(arr, 3);
    System.out.println(Arrays.toString(topk2));
  }

  /**
   * 最小的前k个数，使用大顶堆
   * @param arr
   * @param k
   * @return
   */
  public static int[] getLeastNumbers(int[] arr, int k) {
    if (k == 0 || arr.length == 0) {
      return new int[0];
    }
    // 默认是小根堆，实现大根堆需要重写一下比较器。
    Queue<Integer> pq = new PriorityQueue<>((v1, v2) -> v2 - v1);
    for (int num: arr) {
      if (pq.size() < k) {
        pq.offer(num);
      } else if (num < pq.peek()) {
        pq.poll();
        pq.offer(num);
      }
    }

    // 返回堆中的元素
    int[] res = new int[pq.size()];
    int idx = 0;
    for(int num: pq) {
      res[idx++] = num;
    }
    return res;
  }

  /**
   * 最大的前k个数，使用小顶堆
   * @param arr
   * @param k
   * @return
   */
  public static int[] getLeastNumbers2(int[] arr, int k) {
    if (k == 0 || arr.length == 0) {
      return new int[0];
    }
    Queue<Integer> pq = new PriorityQueue<>();
    for (int num: arr) {
      if (pq.size() < k) {
        pq.offer(num);
      } else if (num > pq.peek()) {
        pq.poll();
        pq.offer(num);
      }
    }

    // 返回堆中的元素
    int[] res = new int[pq.size()];
    int idx = 0;
    for(int num: pq) {
      res[idx++] = num;
    }
    return res;
  }
}
