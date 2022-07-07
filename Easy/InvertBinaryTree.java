/**
 * LeetCode problem 226. Invert Binary Tree: https://leetcode.com/problems/invert-binary-tree/
 */
public class Solution {
    /**
     * Inverts the given binary tree
     * Time Complexity: O(N), where N = the number of nodes in the given tree
     * Every node in the tree is visited, and its children are swapped. Thus, the complexity is equal to the number of
     * nodes in the tree.
     * <p>
     * Space Complexity: O(1) or O(H), where H = the height of the given tree.
     * The only extra memory used is the one on the recursive stack, which at most is equal to the height of the tree
     *
     * @param root the root of the binary tree
     * @return the inverted binary tree
     */
    public TreeNode invertTree(TreeNode root) {
        // base case
        if (root == null) return null;
        TreeNode right = root.right;
        TreeNode left = root.left;
        // swap the left and right
        root.right = left;
        root.left = right;
        // invert each child
        invertTree(root.right);
        invertTree(root.left);
        return root;
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