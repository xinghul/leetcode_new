/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // use priority queue, so we don't have to compare K times each step
		Queue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
			public int compare(ListNode l1, ListNode l2) {
				return l1.val - l2.val;
			}
		});

		for (ListNode node: lists)
		{
			if (node != null) {
				queue.add(node);
			}
		}

		ListNode head = new ListNode(0);
		ListNode tmp = head;

		while (!queue.isEmpty())
		{
			ListNode node = queue.poll();

			if (node.next != null) {
				queue.add(node.next);
			}

			tmp.next = new ListNode(node.val);
			tmp = tmp.next;
		}

		return head.next;
    }
}