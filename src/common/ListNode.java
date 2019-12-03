package common;

public class ListNode {
  public int val;
  public ListNode next;
  public ListNode(int x) { val = x; }
  public void print() {
    ListNode listNode = this;
    StringBuilder stringBuilder = new StringBuilder();
    while (listNode != null) {
      if (stringBuilder.length() > 0) {
        stringBuilder.append(",");
      }
      stringBuilder.append(listNode.val);
      listNode = listNode.next;
    }
    System.out.println("(" + stringBuilder.toString() + ")");
  }
}
