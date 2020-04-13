package leetcode;

import java.util.HashMap;

/**
 * 设计和构建一个“最近最少使用”缓存，该缓存会删除最近最少使用的项目。缓存应该从键映射到值(允许你插入和检索特定键对应的值)，并在初始化时指定最大容量。当缓存被填满时，它应该删除最近最少使用的项目。
 *
 * 它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lru-cache-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 方案1，使用HashMap加双向链表，HashMap的key存放put时的key，value存放Node，Node是个双向链表
 *  最近访问和最新插入的数据放到链表的头部，当链表满时，则移除链表尾部节点
 *  利用双向链表来描述节点最近和最远特性，利用hashMap容器来存放真实数据。
 *
 */
public class LRUCache {

  class LRUNode {
    private int key;
    private int value;
    private LRUNode pre;
    private LRUNode next;

    public void setKey(int key) {
      this.key = key;
    }

    public void setValue(int value) {
      this.value = value;
    }
  }

  private HashMap<Integer, LRUNode> lruCache = new HashMap<>();

  private int capacity;

  private LRUNode head; //头节点,占位用不存储任何元素
  private LRUNode tail; //尾节点,占位用不存储任何元素

  public LRUCache(int capacity) {
    this.capacity = capacity;

    head = new LRUNode();
    tail = new LRUNode();

    head.next = tail;
    head.pre = null;

    tail.next = null;
    tail.pre = head;
  }

  /**
   * 移除链表尾部节点：即将tail之前的节点删除，同时返回要删除的节点的key，并从hashmap中删除
   */
  private int popTail() {
    LRUNode node = tail.pre;
    removeNode(node);
    return node.key;
  }

  /**
   * 将指定node移动至队列头部，先删除，后添加至头部
   */
  private void moveToHead(LRUNode node) {
    removeNode(node);
    addToHead(node);
  }

  /**
   * 删除node，改变指定node的前后节点的指针即可
   * @param node
   */
  private void removeNode(LRUNode node) {
    LRUNode preNode = node.pre;
    LRUNode nexNode = node.next;
    preNode.next = nexNode;
    nexNode.pre = preNode;
  }

  /**
   * 将node添加在队列头部
   * 将指定节点添加至head节点的后面，即为队列头部
   * @param node
   */
  private void addToHead(LRUNode node) {
    LRUNode nextNode = head.next;
    node.pre = head;
    head.next = node;
    node.next = nextNode;
    nextNode.pre = node;
  }

  /**
   * get时，如果元素存在，则将元素置于队列头部
   * @param key
   * @return
   */
  public int get(int key) {
    LRUNode node = lruCache.get(key);
    if (node == null) {
      return -1;
    }
    this.moveToHead(node);
    return node.value;
  }

  /**
   * put时，先判断该key对应的节点是否存在，如果节点存在直接更新该节点对应的value即可。
   * 否则，就新创建一个节点，并将该节点插入到链表头部
   * @param key
   * @param value
   */
  public void put(int key, int value) {
    LRUNode node = lruCache.get(key);
    if (node == null) {
      node = new LRUNode();
      node.setKey(key);
      node.setValue(value);
      this.addToHead(node);
      lruCache.put(key, node);
      if (lruCache.size() > capacity) {
        int k = this.popTail();
        lruCache.remove(k);
      }
    } else {
      node.value = value;
      this.moveToHead(node);
    }
  }

  public static void main(String[] args) {
    LRUCache lruCache = new LRUCache(2);
    lruCache.put(1,1); //[1]
    lruCache.put(2,2); //[2,1]
    System.out.println(lruCache.get(1)); //[1,2] => 1
    lruCache.put(3,3);//[3,1]
    System.out.println(lruCache.get(2)); //[3,1] => -1
    lruCache.put(4,4); //[4,3]
    System.out.println(lruCache.get(1)); //-1
    System.out.println(lruCache.get(3)); //3
    System.out.println(lruCache.get(4)); //4

  }
}
