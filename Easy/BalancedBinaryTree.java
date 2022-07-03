/**
 * LeetCode problem 110. Balanced Binary Tree: https://leetcode.com/problems/balanced-binary-tree/
 */
public class Solution {

    // instance var for isBalancedOptimised
    // set to true, since maxDepth only changes to false
    private boolean result = true;

    /**
     * Optimised way of determining whether the given tree is balanced
     * Time Complexity: O(N), where N = the number of nodes in the given tree
     * This version is faster than the non-optimised since the constant factor of N is smaller. This method calls
     * maxDepth() which iterates through the entire tree only once. In the non-optimised version, a call is made at each
     * level to a method which iterates through the tree from a given entry point. Thus, there will be many overlapping
     * subproblems.
     *
     * @param root the root of the tree
     * @return whether the given tree is balanced
     */
    public boolean isBalancedOptimised(TreeNode root) {
        maxDepth(root);
        return result;
    }

    /**
     * Finds the height of the given tree, changes instance variable result to false if there is height difference of
     * more than one between the roots two child elements
     *
     * @param root the root of the tree
     * @return the height of the tree
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            result = false;
        }
        return 1 + Math.max(leftHeight, rightHeight);
    }

    /**
     * Determines whether the given tree is balanced
     * Time Complexity: O(N), where N = the number of nodes in the given tree
     * <p>
     * Space Complexity: O(H), where H = the height of the tree
     * Since this uses recursion, at most there will be H calls to the method. Because Java re-uses space when making a
     * new call, the maximum number of memory addresses on the stack at the same time is the tree height
     *
     * @param root the root of the tree
     * @return whether the given tree is balanced
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        // check if root is leaf
        if (root.left == null && root.right == null) return true;
        // if the height difference of its children is larger than 1, the tree is unbalanced
        if (Math.abs(height(root.left) - height(root.right)) > 1) {
            return false;
        } else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    /**
     * Finds the height of the given tree
     *
     * @param root the root of the tree
     * @return the height of the tree
     */
    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // the height of the tree is equal to 1 + the height of its child with the most elements
        return 1 + Math.max(height(root.left), height(root.right));
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