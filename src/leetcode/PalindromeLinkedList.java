package leetcode;

import common.ListNode;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Example 1:
 *
 * Input: 1->2
 * Output: false
 * Example 2:
 *
 * Input: 1->2->2->1
 * Output: true
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 *
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 */
public class PalindromeLinkedList {

  public static void main(String[] args) {
    ListNode listNode1 = new ListNode(1);
    ListNode listNode2 = new ListNode(2);
    ListNode listNode4 = new ListNode(3);
    ListNode listNode5 = new ListNode(3);
    ListNode listNode6 = new ListNode(2);
    ListNode listNode7 = new ListNode(1);

    listNode1.next = listNode2;
    listNode2.next = listNode4;
    listNode4.next = listNode5;
    listNode5.next = listNode6;
    listNode6.next = listNode7;
    System.out.println(new PalindromeLinkedList().isPalindrome4(listNode1));


    ListNode listNode21 = new ListNode(1);
    ListNode listNode22 = new ListNode(2);
    ListNode listNode23 = new ListNode(3);
    ListNode listNode24 = new ListNode(2);
    ListNode listNode25 = new ListNode(1);

    listNode21.next = listNode22;
    listNode22.next = listNode23;
    listNode23.next = listNode24;
    listNode24.next = listNode25;
    System.out.println(new PalindromeLinkedList().isPalindrome4(listNode21));


    ListNode listNode31 = new ListNode(1);
    ListNode listNode32 = new ListNode(2);
    listNode31.next = listNode32;
    System.out.println(new PalindromeLinkedList().isPalindrome4(listNode31));

    ListNode listNode41 = new ListNode(-129);
    ListNode listNode42 = new ListNode(-129);
    listNode41.next = listNode42;
    System.out.println(new PalindromeLinkedList().isPalindrome4(listNode41));


  }

  /**
   * 方案一，链表法，将原始单链表所有节点的值反转后放到新的链表中，然后比较。LinkedList具有栈的特性。
   *  翻转的技巧：addFirst 将元素压入栈顶
   *  取数的技巧：pop 获取并移除栈顶元素
   * tip: 完全可以使用Stack代替LinkedList
   * @param head
   * @return
   */
  public boolean isPalindrome(ListNode head) {

    LinkedList<Integer> linkedList = new LinkedList<>();

    ListNode current = head;
    while (current != null) {
      linkedList.addFirst(current.val);
      current = current.next;
    }

    ListNode current1 = head;
    while (current1 != null) {
      int x = linkedList.pop();
      if (current1.val != x) {
        return false;
      }
      current1 = current1.next;
    }
    return true;
  }

  /**
   * 方案二，ArrayList数组法，严格边界条件：
   * 如果长度是偶数，例如 length = 6，index = [0,1,2,3,4,5]，中间是 2,3。 length/2 = 3  i<=2, j>=3
   * 如果长度是奇数，例如 length = 5，index = [0,1,2,3,4]，中间是 2。 length/2 = 2  i<=1, j>=2
   * 要点：
   * 1.本方案重点是边界条件
   * 2.注意任何集合对象里面装的都是包装类，每次放入基本类型元素都是个自动装箱过程，但每次取出元素如果没有显示指定基本类型，不会发生自动拆箱，所以不能直接通过==来比较。
   * 3.要使用== 必须使用 intValue 显式拆箱,否则使用equals
   * 缺陷：
   * 1.因为使用了集合类ArrayList来存放元素，它是基于数组类型做的封装，所以耗费空间
   * 2.因为使用了集合类ArrayList，自动扩容会耗费时间，装箱和拆箱也会耗费时间
   * @param head
   * @return
   */
  public boolean isPalindrome2(ListNode head) {
    ArrayList<Integer> list = new ArrayList<>();

    ListNode current = head;
    while (current != null) {
      list.add(current.val);
      current = current.next;
    }
    int j = list.size()-1;
    for (int i = 0; i <= list.size() / 2 - 1 && j >= list.size() / 2 ; i++, j--) {
      if (list.get(i).intValue() != list.get(j).intValue()) {
        return false;
      }
    }
    return true;
  }

  /**
   * 方案二 版本2，ArrayList数组法，宽松边界条件：首位两个指针，左指针从数组头部向左移动，右指针从数组尾部向右移动，每次移动要要确保左指针小于有指针。
   * 本质是方案二的变体，方案二复杂点在于左右指针的边界条件不太好确定
   * 要点：
   * 1.注意任何集合对象里面装的都是包装类，每次放入基本类型元素都是个自动装箱过程，但每次取出元素如果没有显示指定基本类型，不会发生自动拆箱，所以不能直接通过==来比较。
   * 2.包装类比较 要使用== 必须使用 intValue 显式拆箱
   * @param head
   * @return
   */
  public boolean isPalindrome3(ListNode head) {
    ArrayList<Integer> list = new ArrayList<>();

    ListNode current = head;
    while (current != null) {
      list.add(current.val);
      current = current.next;
    }
    int j = list.size()-1;
    for (int i = 0; i <= list.size() - 1 && j >= 0 && i < j; i++, j--) {
      if (list.get(i).intValue() != list.get(j).intValue()) {
        return false;
      }
    }
    return true;
  }


  /**
   * 方案三，基本类型数组法，严格边界条件：
   * 如果长度是偶数，例如 length = 6，index = [0,1,2,3,4,5]，中间是 2,3。 length/2 = 3  i<=2, j>=3
   * 如果长度是奇数，例如 length = 5，index = [0,1,2,3,4]，中间是 2。 length/2 = 2  i<=1, j>=2
   * 本方案类似方案二，重点是边界条件。
   * 本方案唯一缺陷：
   * 为了确定数组长度，需要额外遍历一次单链表。
   * @param head
   * @return
   */
  public boolean isPalindrome4(ListNode head) {
    int length = 0;
    ListNode current = head;
    while (current != null) {
      current = current.next;
      length++;
    }

    int[] arr = new int[length];
    current = head;
    int index = 0;
    while (current != null) {
      arr[index] = current.val;
      current = current.next;
      index++;
    }

    int j = length -1;
    int left = length / 2 - 1;
    int right = length / 2;
    for (int i = 0; i <= left && j >= right ; i++, j--) {
      if (arr[i] != arr[j]) {
        return false;
      }
    }
    return true;
  }
}
