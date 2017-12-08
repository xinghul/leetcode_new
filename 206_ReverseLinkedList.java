/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

 // 1 -> 2 -> 3
 // before: dummy.next = 1, next = 2
 // #1: tmp = 3, prev = 1, 2.next = 1, dummy.next = 2, next = 3
 // #2: tmp = null, prev = 2, 3.next = 2, dummy.next = 3, next = null

 // 1 -> 2
 // before: dummy.next = 1, next = 2
 // #1: tmp = null, prev = 1, 2.next = 1, dummy.next = 2, next = null
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode curr;
        ListNode prev = null;
        while (dummy.next != null)
        {
            curr = dummy.next;
            dummy.next = curr.next;
            
            curr.next = prev;
            prev = curr;
        }
        
        return prev;
    }
}