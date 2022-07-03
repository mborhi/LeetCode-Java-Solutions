/**
 * LeetCode probelm 104. Maximum Depth of Binary Tree: https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */
public class Solution {
    /**
     * Finds the height of the given binary tree
     * Time Complexity: O(N), where N = the number of nodes in the given binary tree
     * <p>
     * Space Complexity: O(H), where H = the height of the binary tree
     *
     * @param root the root of the binary tree
     * @return the height of the binary tree
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
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