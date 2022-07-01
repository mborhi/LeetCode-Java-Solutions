/**
 * LeetCode solution for 94. Binary Tree Inorder Traversal: https://leetcode.com/problems/binary-tree-inorder-traversal/
 */
public class Solution {
    /**
     * Inorder traversal of the given binary tree
     * Time Complexity: O(N), where N = the number of nodes in the given tree
     * Since every node must be visited, the time complexity is equal to the number of nodes
     * <p>
     * Space Complexity: O(N), where N = the number of nodes in the given tree
     *
     * @param root the root of the given binary tree
     * @return a list of all the nodes inorder
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> lst = new ArrayList<>();
        inorderTraversalHelper(root, lst);
        return lst;
    }

    public void inorderTraversalHelper(TreeNode entry, List<Integer> lst) {
        // left, parent, right
        if (root != null) {
            inorderTraversalHelper(entry.left, lst);
            lst.add(root.val);
            inorderTraversalHelper(entry.right, lst);
        }
    }

}

/**
 * Binary tree class for inorderTraversal
 */
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