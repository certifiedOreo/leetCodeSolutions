import java.util.*;

  class ListNode {
        int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }


class Solution {
    public ListNode partition(ListNode head, int x) {
        
        ListNode firstPart = new ListNode(0);
        ListNode secondPart = new ListNode(0);
        ListNode head1 = firstPart;   //actual head will be head1.next
        ListNode head2 = secondPart;
        
        
        while(head!=null){
            if(head.val< x){
                firstPart.next = head;
                firstPart = firstPart.next;
            }
            
            else{
                secondPart.next= head;
                secondPart = secondPart.next;
            }
            
            head = head.next;
        }
        
        secondPart.next = null;
        firstPart.next = head2.next;
        
        return head1.next;
        
        
    }
}