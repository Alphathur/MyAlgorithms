package leetcode;

import common.ListNode;
import java.util.LinkedList;

/**
 * 给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
 *
 *  
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 * 进阶:
 *
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 *
 * 示例:
 *
 * 输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出: 7 -> 8 -> 0 -> 7
 *
 * 输入: (5 -> 6) + (5)
 * 输出: 0 -> 7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddTwoNumbersII {


  public static void main(String[] args) {
    ListNode l11 = new ListNode(7);
    ListNode l12 = new ListNode(2);
    ListNode l13 = new ListNode(4);
    ListNode l14 = new ListNode(3);
    l11.next = l12;
    l12.next = l13;
    l13.next = l14;

    ListNode l21 = new ListNode(5);
    ListNode l22 = new ListNode(6);
    ListNode l23 = new ListNode(4);
    l21.next = l22;
    l22.next = l23;


    l11.print();
    l21.print();

    addTwoNumbers(l11, l21);

    ListNode l31 = new ListNode(5);
    ListNode l41 = new ListNode(5);

    addTwoNumbers(l31, l41);

    ListNode l51 = new ListNode(5);
    ListNode l52 = new ListNode(6);
    l51.next = l52;

    ListNode l61 = new ListNode(5);

    addTwoNumbers(l51, l61);
  }

  /**
   * 方案一：使用两个LinkedList，通过addFirst分别实现两个ListNode的反转。再通过一个LinkedList存储和的信息。
   * LinkedList::addFirst 将数据插入头节点，最后插入的元素在前面。
   * LinkedList::removeFirst 删除头节点元素，最后插入的元素最先删除。
   * LinkedList::isEmpty 判断当前链表是否为空
   * 本质就是通过LinkedList实现了一个栈的功能
   * @param l1
   * @param l2
   */
  private static void addTwoNumbers(ListNode l1, ListNode l2){

    LinkedList<Integer> l1List = new LinkedList<>();
    while (l1 != null) {
      l1List.addFirst(l1.val);
      l1 = l1.next;
    }

    LinkedList<Integer> l2List = new LinkedList<>();
    while (l2 != null) {
      l2List.addFirst(l2.val);
      l2 = l2.next;
    }

    int s = 0;
    LinkedList<Integer> linkedList = new LinkedList();
    while (!l1List.isEmpty() || !l2List.isEmpty() || s != 0) {
      Integer val1 = l1List.isEmpty() ? 0 : l1List.removeFirst();
      Integer val2 = l2List.isEmpty() ? 0 : l2List.removeFirst();
      linkedList.addFirst((val1+val2+s)%10);
      s = (val1+val2+s)/10;
    }
    ListNode head = new ListNode(0);
    ListNode result = head;
    while (!linkedList.isEmpty()) {
      head.next = new ListNode(linkedList.removeFirst());
      head = head.next;
    }
    result.next.print();
  }


}
