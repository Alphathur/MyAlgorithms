package leetcode;

import common.ListNode;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个链表，判断链表中是否有环。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * <p>
 * 解释：当链表的尾节点连接到链表中的任意一个节点时，称当前链表为环形链表
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/linked-list-cycle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CycleLinkedList {

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
    listNode7.next = listNode2;

    System.out.println(new CycleLinkedList().hasCycle(listNode1));

    test();
  }


  /**
   * [-21,10,17,8,4,26,5,35,33,-7,-16,27,-12,6,29,-12,5,9,20,14,14,2,13,-24,21,23,-21,5] -1
   */
  private static void test() {
    ListNode listNode1 = new ListNode(-21);
    ListNode listNode2 = new ListNode(10);
    ListNode listNode4 = new ListNode(17);
    ListNode listNode5 = new ListNode(8);
    ListNode listNode6 = new ListNode(4);
    ListNode listNode7 = new ListNode(26);
    ListNode listNode8 = new ListNode(5);
    ListNode listNode9 = new ListNode(35);
    ListNode listNode10 = new ListNode(33);
    ListNode listNode11 = new ListNode(-7);
    ListNode listNode12 = new ListNode(-16);
    ListNode listNode13 = new ListNode(27);
    ListNode listNode14 = new ListNode(-12);
    ListNode listNode15 = new ListNode(6);
    ListNode listNode16 = new ListNode(29);
    ListNode listNode17 = new ListNode(-12);
    ListNode listNode18 = new ListNode(5);
    ListNode listNode19 = new ListNode(9);
    ListNode listNode20 = new ListNode(20);
    ListNode listNode21 = new ListNode(14);
    ListNode listNode22 = new ListNode(14);
    ListNode listNode23 = new ListNode(2);
    ListNode listNode24 = new ListNode(13);
    ListNode listNode25 = new ListNode(-24);
    ListNode listNode26 = new ListNode(21);
    ListNode listNode27 = new ListNode(23);
    ListNode listNode28 = new ListNode(-21);
    ListNode listNode29 = new ListNode(5);

    listNode1.next = listNode2;
    listNode2.next = listNode4;
    listNode4.next = listNode5;
    listNode5.next = listNode6;
    listNode6.next = listNode7;
    listNode7.next = listNode8;
    listNode8.next = listNode9;
    listNode9.next = listNode10;
    listNode10.next = listNode11;
    listNode11.next = listNode12;
    listNode12.next = listNode13;
    listNode13.next = listNode14;
    listNode14.next = listNode15;
    listNode15.next = listNode16;
    listNode16.next = listNode17;
    listNode17.next = listNode18;
    listNode18.next = listNode19;
    listNode19.next = listNode20;
    listNode20.next = listNode21;
    listNode21.next = listNode22;
    listNode22.next = listNode23;
    listNode23.next = listNode24;
    listNode24.next = listNode25;
    listNode25.next = listNode26;
    listNode26.next = listNode27;
    listNode27.next = listNode28;
    listNode28.next = listNode29;

    System.out.println(new CycleLinkedList().hasCycle1(listNode1));

  }


  /**
   * 方案一：快慢双指针法，如果是环形链表，快指针总会和慢指针重合。类似环形跑道中的赛跑，速度不一致，总会交汇。
   * 注意要点：快慢指针的起始点必须不同！否则下面这个循环一开始执行就是true。
   */
  public boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) {
      return false;
    }
    ListNode slow = head;
    ListNode fast = head.next;
    while (fast != null && fast.next != null) {
      if (fast == slow) {
        return true;
      }
      fast = fast.next.next;
      slow = slow.next;
    }
    return false;
  }

  /**
   * 方案二：Set 容器法，HashSet的add方法用来判断一个元素是否在容器中，如果在，则不添加，返回false，如果不在，则添加，并返回true
   *
   */
  public boolean hasCycle1(ListNode head) {
    ListNode curr = head;
    Set<ListNode> filter = new HashSet<>();
    while (curr != null) {
      if (!filter.add(curr)) {
        return true;
      }
      curr = curr.next;
    }
    return false;
  }

}
