package leetcode;

import common.ListNode;
import java.util.Stack;

/**
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseSingleLinkedList {

  public static void main(String[] args) {
    ListNode listNode1 = new ListNode(1);
    ListNode listNode2 = new ListNode(2);
    ListNode listNode4 = new ListNode(3);
    ListNode listNode5 = new ListNode(4);
    ListNode listNode6 = new ListNode(6);
    ListNode listNode7 = new ListNode(7);

    listNode1.next = listNode2;
    listNode2.next = listNode4;
    listNode4.next = listNode5;
    listNode5.next = listNode6;
    listNode6.next = listNode7;
    ListNode listNode = new ReverseSingleLinkedList().reverseList1(listNode1);
    listNode.print();
  }

  /**
   * 方案一，使用外部容器，例如栈Stack
   * @param head
   * @return
   */
  public ListNode reverseList(ListNode head) {
    Stack<Integer> stack = new Stack<>();
    ListNode current = head;
    while (current != null) {
      stack.push(current.val);
      current = current.next;
    }
    ListNode listNode = new ListNode(0);
    ListNode result = listNode;
    while (!stack.isEmpty()) {
      listNode.next = new ListNode(stack.pop());
      listNode = listNode.next;
    }
    return result.next;
  }


  /**
   * 方案二：双指针迭代
   * 1）申请两个指针，pre和curr， pre指向null，curr指向head
   * 2）迭代curr，都将curr的next指向pre，然后pre和head都向前移动一位
   * 过程：
   * 1->2->3->4->5->6->7
   *
   * 1
   * 2->1
   * 3->2->1
   * 4->3->2->1
   * 5->4->3->2->1
   * 6->5->4->3->2->1
   * 7->6->5->4->3->2->1
   *
   * 0):curr = 1->2->3->4->5->6->7, pre = null
   * 1):curr = 1->null,  pre = 1->null
   * 2):curr = 2->1->null, pre = 2->1->null
   * 3):curr = 3->2->1->null, pre = 3->2->1->null
   * 4):curr = 4->3->2->1->null, pre = 4->3->2->1->null
   * @param head
   * @return
   */
  public ListNode reverseList1(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    while (curr != null) {
      ListNode nextTemp = curr.next;
      curr.next = prev; //翻转，将箭头看成是next，每次执行时链表发生断裂：链表头节点与其它节点断开
      prev = curr;      //prev指针前移
      curr = nextTemp;  //curr指针前移
    }
    return prev;
  }
}
