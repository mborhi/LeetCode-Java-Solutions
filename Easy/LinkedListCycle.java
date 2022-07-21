/**
 * LeetCode solution for problem 141. Linked List Cycle: https://leetcode.com/problems/linked-list-cycle/
 */
public class Solution {

    /**
     * Determines whether the given linked list has a cycle
     * This solution uses Floyd's Cycle detection algorithm.
     * Time Complexity: O(N), where N = the number of nodes in the linked list
     * <p>
     * Space Complexity: O(1)
     * The fast pointer moves twice as fast as the slow pointer, thus if there is a cycle, eventually the pointers will
     * be at the same position. The only extra space required is to store the two references to the given linked list,
     * which is constant space.
     *
     * @param head the head of the linked list
     * @return whether there are cycles
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) return true;
        }
        return false;
    }

    /**
     * Determines whether the given linked list has a cycle
     * This solution uses extra space.
     * Time Complexity: O(N), where N = the number of nodes in the linked list
     * All nodes are iterated over at least once.
     * <p>
     * Space Complexity: O(N)
     * To keep track of the nodes visited, an ArrayList is used. At most this will have a size equivalent to the number
     * of nodes in the array list if there is no cycle.
     *
     * @param head the head of the linked list
     * @return whether there are cycles
     */
    public boolean hasCycleExtraSpace(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode curr = head;
        ArrayList<ListNode> visited = new ArrayList<>();
        while (curr != null) {
            if (visited.contains(curr)) {
                return true;
            }
            visited.add(curr);
            curr = curr.next;
        }
        return true;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}