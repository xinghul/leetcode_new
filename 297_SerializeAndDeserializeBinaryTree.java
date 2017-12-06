/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

		if (root == null) {
			return "";
		}

		queue.add(root);
		StringBuilder sb = new StringBuilder();
		while (!queue.isEmpty())
		{
			TreeNode node = queue.poll();

			if (node != null) {
				sb.append(node.val + ",");

				queue.add(node.left);
				queue.add(node.right);
			} else {
				sb.append("#,");
			}
		}

		return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] token = data.split(",");

		if (token.length == 0 || token[0] == "#") {
			return null;
		}

		TreeNode root = Integer.parseInt(token[0]);
		Queue<TreeNode> queue = new LinkedList<>();

		int index = 1;
		while (index < token.length - 1)
		{
			TreeNode node = queue.poll();

			if (token[index] == "#") {
				node.left = null;
			} else {
				node.left = new TreeNode(Integer.parseInt(token[index]));

				queue.add(node.left);
			}
			index++;

			if (token[index] == "#") {
				node.right = null;
			} else {
				node.right = new TreeNode(Integer.parseInt(token[index]));

				queue.add(node.right);
			}
			index++;
		}

		return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));