/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {

    private Stack<TreeNode> stack;
    private List<Integer> list;
    int index;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        list = new ArrayList<>();
        index = 0;

        while (root != null)
        {
            stack.push(root);

            root = root.left;
        }

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            list.add(node.val);
            node = node.right;

            while (node != null) {
                stack.push(node);
                
                node = node.left;
            }
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return index < list.size();
    }

    /** @return the next smallest number */
    public int next() {
        return list.get(index++);
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */