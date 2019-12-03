package leetcode;

import common.ListNode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807

 *
 * 输入：(6 -> 7 -> 3 - > 2) + (7 -> 6 -> 4)
 * 输出：3 -> 4 -> 8 -> 2
 * 原因：2376 + 467 = 2843

 *
 *  * 输入：(2 -> 4 -> 3 -> 1) + (5 -> 6 -> 4)
 *  * 输出：7 -> 0 -> 8 -> 1
 *  * 原因：1342+465 = 1807
 *
 *  输入 （9 -> 8） + (1)
 *  输出  (0 -> 9)
 *
 *  输入 （5） + (5)
 *  输出  (0 -> 1)
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddTwoNumbers {


  public static void main(String[] args) {
    ListNode l11 = new ListNode(2);
    ListNode l12 = new ListNode(4);
    ListNode l13 = new ListNode(3);
    l11.next = l12;
    l12.next = l13;

    ListNode l21 = new ListNode(5);
    ListNode l22 = new ListNode(6);
    ListNode l23 = new ListNode(4);
    l21.next = l22;
    l22.next = l23;

    ListNode listNode = addTwoNumbers(l11, l21);
    listNode.print();

    ListNode listNode1 = addTwoNumbers(l11, l21);
    listNode1.print();

    ListNode l31 = new ListNode(5);
    ListNode l32 = new ListNode(5);

    ListNode listNode2 = addTwoNumbers(l31, l32);
    listNode2.print();

    ListNode l41 = new ListNode(9);
    ListNode l42 = new ListNode(8);
    ListNode l52 = new ListNode(1);
    l41.next = l42;


    System.out.println("============================");
    //
    ListNode listNode0 = addTwoNumbers1(l11, l21);
    listNode0.print();

    ListNode listNode11 = addTwoNumbers1(l11, l21);
    listNode11.print();

    ListNode listNode21 = addTwoNumbers1(l31, l32);
    listNode21.print();

    ListNode listNode31 = addTwoNumbers1(l41, l52);
    listNode31.print();

  }

  public static ListNode test(ListNode l1, ListNode l2) {
    int temp = l1.val + l2.val;
    ListNode result = new ListNode(temp%10);
    int s = temp/10;

    int temp1 = l1.next.val + l2.next.val + s;
    ListNode result1 = new ListNode(temp1%10);
    int s1 = temp1/10;
    result.next = result1;

    int temp2 = l1.next.next.val + l2.next.next.val + s1;
    ListNode result2 = new ListNode(temp2%10);
    int s2 = temp2/10;
    result1.next = result2;


    return result;
  }

  /**
   * 思路：
   * 1）每个节点的值，其实就是【当前两个节点之和 + 前驱节点之和对10取整]再对10取余
   * 2）x/10 取整：5/10=0， 9/10=0，13/10=1，18/10=1
   * 3）x%10 取余：5%10=5，9%10=9，13%10=3，18%10=8
   * 4）什么条件需要追加子节点？
   *    a.判断前驱节点之和对10取整是否大于0,大于0必然追加。
   *    b.判断任意当前两节点是否含有子节点，如果任一存在子节点，则必然追加。
   * @param l1
   * @param l2
   * @return
   */
  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode result = new ListNode(0);
    ListNode finalNode = result;
    int s = 0; //used to divide 10
    while (l1 != null || l2 != null) {//l1,l2:当前参与元素的节点，也是result.next的前驱节点
      int val1 = l1 == null ? 0 : l1.val;
      int val2 = l2 == null ? 0 : l2.val;
      int temp = val1 + val2 + s;
      result.val = temp % 10; //result:当前节点
      s = temp / 10;

      l1 = l1 == null ? null : l1.next;
      l2 = l2 == null ? null : l2.next;

      if (s > 0 || l1 != null || l2 != null) {
        result.next = new ListNode(s);
        result = result.next;
      }
    }
    return finalNode;
  }

  public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
    ListNode head = new ListNode(0);
    ListNode result = head;
    int carry = 0;

    while (l1 != null || l2 != null || carry > 0) {
      int total = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
      result.next = new ListNode(total % 10);
      carry = total / 10;
      l1 = l1 == null ? null : l1.next;
      l2 = l2 == null ? null : l2.next;
      result = result.next;
    }

    return head.next;
  }
}


