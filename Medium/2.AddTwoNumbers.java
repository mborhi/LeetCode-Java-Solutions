/**
 * LeetCode problem 2. Add Two Numbers: https://leetcode.com/problems/add-two-numbers/
 */
public class Solution {

    /**
     * Adds the values of two linked lists
     * Time Complexity: O(max(N+M)), where N = the length of the first linked list, and M = the length of the second
     * linked list
     * Both of the linked lists are iteratred through all the way.
     * <p>
     * Space Complexity: O(S), where S = the number of digits in the sum of the two linked lists
     * To store the solution, a new linked list is created which depends on the size of the sum of the two numbers
     * stored in the linked lists.
     *
     * @param l1 the first linked list
     * @param l2 the second liked list
     * @return the sum of the values stored in the linked lists
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode solution = new ListNode(0);
        ListNode curr = solution;
        ListNode a = l1;
        ListNode b = l2;
        int remainder = 0;
        // only end if both linked list head pointers are null
        while (a != null || b != null) {
            // since one linked list may be longer than the other, check for null pointers
            int aVal, bVal;
            if (a != null) {
                aVal = a.val;
            } else {
                // if null, value becomes 0 to not add a value that has already been added
                aVal = 0;
            }
            if (b != null) {
                bVal = b.val;
            } else {
                // if null, value becoes 0 to not add a value that has already been added
                bVal = 0;
            }
            // the sum is the values stored in the two nodes plus any value carried over from the previous nodes
            int sum = aVal + bVal + remainder;
            // carry the one if there needed
            remainder = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            // only advance pointer if the current is not null
            if (a != null) a = a.next;
            if (b != null) b = b.next;
        }
        // if there is a remainder from the last added nodes, make a new node with this value
        if (remainder > 0) {
            curr.next = new ListNode(remainder);
        }
        // addition of values starts from the 'next' node of solution, so return list from there
        return solution.next;
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