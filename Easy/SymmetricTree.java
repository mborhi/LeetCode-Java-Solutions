/**
 * LeetCode problem 101. Symmetric Tree: https://leetcode.com/problems/symmetric-tree/
 */
public class Solution {

    /**
     * Determines whether the given tree is symmetric
     * Time Complexity: O(N), where N = the number of nodes in the given tree
     * Every node is visited during traversal.
     * <p>
     * Space Complexity: O(H), where H = the height of the tree
     * Since this solution uses recursion, the call stack at most will have a size equivalent to the height of the tree.
     *
     * @param root the root of the tree
     * @return whether its symmetric
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;

        return t1.val == t2.val && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
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