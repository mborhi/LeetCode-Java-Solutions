/**
 * LeetCode problem 112. Path Sum: https://leetcode.com/problems/path-sum/
 */
public class Solution {
    /**
     * Determines whether the given tree has a path from the given root to a leaf with the target sum
     * Time Complexity: O(N), where N = the number of nodes in the given tree
     * Since we only know that the given tree is a binary tree, we cannot deduce anything about which path to travel to.
     * Thus, every path, and thereby node, must be visited.
     * <p>
     * Space Complexity: O(H), where H = the height of the given tree
     * Because recursion is used to solve this problem, at most there will be H calls to the method. Because Java
     * re-uses space when making a new call, the maximum number of memory addresses on the stack at the same time is the
     * tree height
     *
     * @param root      the root of the given tree
     * @param targetSum the sum which the path from the root to a leaf must add up to
     * @return whether there is a path from the root to a leaf which adds up to the targetSum
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // corner case for empty tree
        if (root == null) return false;
        // calculate the new target
        int adjustedSum = targetSum - root.val;
        // check if leaf
        if (root.left == null && root.right == null) {
            return targetSum == 0;
        }
        // check whether either of the paths have a correct sum
        if (root.left != null && root.right != null) {
            return hasPathSum(root.left, adjustedSum) || hasPathSum(root.right, adjustedSum);
        } else if (root.left != null) {
            return hasPathSum(root.left, adjustedSum);
        } else {
            return hasPathSum(root.right, adjustedSum);
        }
    }
}

/**
 * Binary tree node
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