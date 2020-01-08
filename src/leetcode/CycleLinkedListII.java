package leetcode;

import common.ListNode;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * 说明：不允许修改给定的链表。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：tail connects to node index 1
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 上一个案例环形链表，只需要判断链表是否为环形链表即可，它不关注形成环的第一个节点是什么，然而本案例关注的是形成环形链表的最初始节点。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CycleLinkedListII {


  /**
   * 方案一，快慢指针法，类似于龟兔赛跑，假设兔子的速度是乌龟的两倍，那么必定有 2 *（a+b） = f + a +b +a, 所以f=b
   * 也就是说通过快慢指针法先找到相遇点，然后从相遇点和头节点分别放两个乌龟同时开始移动，当两个乌龟再次相遇时，相遇节点即为所求节点
   * @param head
   * @return
   */
  public ListNode detectCycle(ListNode head) {
    ListNode slow = cycleSlowNode(head);
    if (slow == null) {
      return null;
    }
    ListNode ptr1 = head;
    ListNode ptr2 = slow;
    while (ptr1 != ptr2) {
      ptr1 = ptr1.next;
      ptr2 = ptr2.next;
    }
    return ptr1;
  }

  public ListNode cycleSlowNode(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (fast == slow) {
        return slow;
      }
    }
    return null;
  }

  /**
   * 方案二：HashSet 容器法
   * @param head
   * @return
   */
  public ListNode detectCycle2(ListNode head) {
    Set<ListNode> set = new HashSet<>();
    ListNode curr = head;
    while (curr != null) {
      if (!set.add(curr)) {
        return curr;
      }
      curr = curr.next;
    }
    return null;
  }
}
