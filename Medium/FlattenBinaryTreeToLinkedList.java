/**
 * LeetCode solution for 114. Flatten Binary Tree to Linked List:
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */
public class Solution {

    /**
     * Flattens the given binary tree to a linked list
     *
     * Time Complexity: O(N), where N = the number of roots
     * All of the nodes in the given tree is visited and switched accordingly
     *
     * Space Complexity: O(N)
     * Since the previous tree is kept track of in the helper method, the extra space is used is equivalent to the
     * number of nodes in the given tree.
     * @param root
     */
    public void flatten(TreeNode root) {
        flattenHelper(root, null);
    }

    public TreeNode flattenHelper(TreeNode root, TreeNode prev) {
        if (root == null)
            return prev;

        TreeNode right = flattenHelper(root.right, prev);
        TreeNode left = flattenHelper(root.left, right);

        root.right = left;
        root.left = null;

        return root;
    }

    /**
     * Uses a recursive pre-order traversal and a list to flatten the given binary tree
     *
     * @param root the root of the binary tree
     */
    public void flattenRecur(TreeNode root) {
        // left child to node, right to null
        // linked list has pre-order traversal of binary tree
        if (root != null) {
            // root, left, right
            ArrayList<Integer> stack = new ArrayList<>();
            flattenRecurHelper(root, stack);
            // assign values from check
            TreeNode curr = root;
            while (!stack.isEmpty()) {
                curr.right = new TreeNode(stack.get(0);
                stack.remove(0);
                curr.left = null;
                curr = curr.right;
            }
        }
    }

    public void flattenRecurHelper(TreeNode entry, ArrayList<Integer> stack) {
        // process root
        if (entry == null) return;
        // add to stack
        stack.add(entry.val);
        // process children
        flattenRecurHelper(entry.left, stack);
        flattenRecurHelper(entry.right, stack);

    }
}

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {

    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}