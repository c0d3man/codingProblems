/**
 * Given a linked list, remove the nth node from the end of list and return its head.

 For example,
 Given linked list: 1->2->3->4->5, and n = 2.

 After removing the second node from the end, the linked list becomes 1->2->3->5.
 */
public class RemoveNthNode {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null)
            return head;
        ListNode first = head;
        for(int i=0;i<n;i++)
            first=first.next;


        ListNode second = head;
        if(first==null){
            head=head.next;
            second.next=null;
            return head;
        }
        while(first.next !=null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return head;
    }
}
