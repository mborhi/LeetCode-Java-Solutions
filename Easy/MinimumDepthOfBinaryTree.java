/**
 * Solution for 111. Minimum Depth for Binary Tree: https://leetcode.com/problems/minimum-depth-of-binary-tree/
 */
public class Solution {
    /**
     * Finds the minimum depth of the given tree using Breadth First Search
     * Time Complexity: O(N), where N = the number of nodes in the given tree
     * <p>
     * Space Complexity: O(N)
     *
     * @param root the root of the tree
     * @return the minimum depth
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr.left == null && curr.right == null) return depth;
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
            depth += 1;
        }
        return 0;
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