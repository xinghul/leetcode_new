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
    private HashMap<TreeNode, Integer> map = new HashMap<>();
    private int tilt = 0;

    public int findTilt(TreeNode root) {
        calculateSum(root);

        calculateTilt(root);

        return tilt;
    }

    private int calculateSum(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int sum = node.val + calculateSum(node.left) + calculateSum(node.right);

        map.put(node, sum);

        return sum;
    }

    private void calculateTilt(TreeNode node) {
        if (node == null) {
          return;
        }

        int leftSum = node.left != null ? map.get(node.left) : 0;
        int rightSum = node.right != null ? map.get(node.right) : 0;

        tilt += Math.abs(leftSum - rightSum);

        calculateTilt(node.left);
        calculateTilt(node.right);
    }
}