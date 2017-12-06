/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
	int max = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root != null) {
			getPathLength(root, 0);
		}

		return max;
    }

	private int getPathLength(TreeNode node, int currLength) {
		if (currLength > max) {
			max = currLength;
		}

		int leftLength = 0;
		if (node.left != null) {
			if (node.left.val == node.val) {
				leftLength = 1 + getPathLength(node.left, currLength + 1);
			} else {
				getPathLength(node.left, 0);
			}
		}

		int rightLength = 0;
		if (node.right != null) {
			if (node.right.val == node.val) {
				rightLength = 1 + getPathLength(node.right, currLength + 1);
			} else {
				getPathLength(node.right, 0);
			}
		}

		if (leftLength + rightLength > max) {
			max = leftLength + rightLength;
		}

		return Math.max(leftLength, rightLength);
	}
}