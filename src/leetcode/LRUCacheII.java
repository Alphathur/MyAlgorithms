package leetcode;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

/**
 * 利用LinkedHashMap自身特性实现LRU缓存，重写accessOrder属性和removeEldestEntry方法即可
 * LinkedHashMap中，元素按照插入顺序排序，所以最早插入的元素在头部，最近插入的元素在尾部。所以map尾部的元素都是最新的。
 * accessOrder默认为true，表示按照元素的插入顺序排序，先插入的在前面，后插入的在后面。
 * accessOrder为false时，表示按照元素的访问顺序排序，每当调用get或者getOrDefault时，对链表的所有entry重新排序，会将刚访问的节点排到链表尾部
 * removeEldestEntry默认返回为false，表示不会移除链表中最老的数据
 * removeEldestEntry为true时，移除链表头部数据。
 *
 * 和LRUCache的区别：LRUCache最近访问的元素位于链表头部，LRUCacheII最近访问的元素位于链表尾部
 */
public class LRUCacheII extends LinkedHashMap<Integer, Integer> {

  private int capacity;

  public LRUCacheII(int capacity) {
    super(capacity, 1, true);
    this.capacity = capacity;
  }

  public int get(int key) {
    return super.getOrDefault(key, -1);
  }

  @Override
  protected boolean removeEldestEntry(Entry<Integer, Integer> eldest) {
    return super.size() > capacity;
  }


  public static void main(String[] args) {
    LRUCacheII lruCache = new LRUCacheII(2);
    lruCache.put(1,1); //[1]
    System.out.println(lruCache);

    lruCache.put(2,2); //[1,2]
    System.out.println(lruCache);

    lruCache.get(1); //[2,1]
    System.out.println(lruCache);

    lruCache.put(3,3);//[1,3]
    System.out.println(lruCache);

    lruCache.get(2); //-1
    System.out.println(lruCache);

    lruCache.put(4,4); //[3,4]
    System.out.println(lruCache);

    System.out.println(lruCache.get(1)); //-1
    System.out.println(lruCache.get(3)); //3
    System.out.println(lruCache.get(4)); //4
  }
}
