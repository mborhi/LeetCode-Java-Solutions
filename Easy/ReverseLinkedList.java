/**
 * LeetCode problem 206. Reverse Linked List: https://leetcode.com/problems/reverse-linked-list/
 */
public class Solution {
    /**
     * Reverses the given LinkedList
     * <p>
     * Time Complexity: O(N), where N = the number of nodes in the given Linked List
     * The method iterates over every element in the given linked list and stores the values in reverse order.
     * <p>
     * Space Complexity: O(N), where N = the number of nodes in the given Linked List
     * A new Linked List equivalent in size to the given Linked List is created and returned
     *
     * @param head the head of the of the linked list
     * @return the reversed Linked List
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode curr = null;
        while (head != null) {
            ListNode end = new ListNode(head.val);
            end.next = curr;
            curr = end;
            head = head.next;
        }
        return curr;
    }

    /**
     * Recursivley reverses the given linked list
     */
    public ListNode reverseListRecur(ListNode head) {
        return reverseListRecurHelper(head, null);
    }

    public ListNode reverseListRecurHelper(ListNode head, ListNode rev) {
        if (head == null) return rev;
        ListNode next = head.next;
        head.next = rev;
        return reverseListRecurHelper(next, head);
    }
}

/**
 * LinkedList class for problem
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}