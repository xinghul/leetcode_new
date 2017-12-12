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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
          return result;
        }

        queue.add(root);
        while (!queue.isEmpty()) {
          Queue<TreeNode> nextQueue = new LinkedList<>();
          List<Integer> tmp = new ArrayList<>();

          while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node != null) {
              if (node.left != null) {
                nextQueue.add(node.left);
              }
              if (node.right != null) {
                nextQueue.add(node.right);
              }

              tmp.add(node.val);
            }
          }

          result.add(tmp);
          queue = nextQueue;
        }

        return result;
    }
}