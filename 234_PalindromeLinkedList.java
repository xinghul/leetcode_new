/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 // 1 2 3 4
 // 1 2 3
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
          return true;
        }
        // revert second half, compare
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null)
        {
          slow = slow.next;
          fast = fast.next.next;
        }

        // revert second half
        ListNode second = slow.next;
        ListNode dummy = new ListNode(0);

        // 1->2->3
        dummy.next = second;
        ListNode curr = second, prev = null;
        while (curr != null) {
          dummy.next = curr.next;
          curr.next = prev;

          prev = curr;
          curr = dummy.next;
        }

        // prev is the new head
        while (prev != null) {
          if (prev.val != head.val) {
            return false;
          }

          prev = prev.next;
          head = head.next;
        }

        return true;
    }
}