package leetcode;

import common.ListNode;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveNthFromEndLinkedList {

  public static void main(String[] args) {
    ListNode listNode1 = new ListNode(1);
    ListNode listNode2 = new ListNode(2);
    ListNode listNode4 = new ListNode(3);
    ListNode listNode5 = new ListNode(4);
    ListNode listNode6 = new ListNode(5);
    ListNode listNode7 = new ListNode(6);

    listNode1.next = listNode2;
    listNode2.next = listNode4;
    listNode4.next = listNode5;
    listNode5.next = listNode6;
    listNode6.next = listNode7;
    listNode1.print();
    ListNode ln = new RemoveNthFromEndLinkedList().removeNthFromEnd(listNode1, 4);
    ln.print();

    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    node1.next = node2;

    node1.print();
    ListNode ln1 = new RemoveNthFromEndLinkedList().removeNthFromEnd(node1, 1);
    ln1.print();
  }

  /**
   * 双指针法，两个指针间隔n的间距，从头节点开始遍历，当尾节点的next为null时，当前节点停止遍历，并将当前节点的next指向next.next来实现倒数第n个节点的删除。
   * 1->2->3->4->5
   * curr:head, temp:curr, behind:curr.next.next
   * curr:head.next, temp:curr, behind:curr.next.next
   * ...
   * if(behind.next == null) {
   *   curr.next = temp.next.next //将倒数第n个几点删除
   * }
   *
   * 1->2  n=2
   * curr: 1-2, temp: 1->2, behind: null
   *
   *
   *
   * @param head
   * @param n
   * @return
   */
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode result = head;
    ListNode curr = head;
    ListNode behind = this.behindNth(curr,n);
    if (behind == null) { //当behind为null，意味着n已经超过链表长度或者巧合等于链表长度，此时要删除的节点正是头节点
      return result.next;
    }
    while (behind != null && behind.next != null) {
      curr = curr.next;
      behind = this.behindNth(curr, n);
    }
    curr.next = curr.next.next; //删除后一个节点
    return result;
  }

  private ListNode behindNth(ListNode curr, int n) {
    ListNode ln = curr;
    for (int i = 0; i < n; i++) {
      ln = curr.next;
      curr = ln;
    }
    return ln;
  }

}
