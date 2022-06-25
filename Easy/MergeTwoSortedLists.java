/**
 * LeetCode problem 21. Merge Two Sorted Lists: https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class Solution {

    /**
     * Merges two sorted linked lists into one sorted linked list
     * Time Complexity: O(max(N)), where N = length of the first list, and M = length of the second list
     * The while loop runs until either of the two lists are empty, after which in a single step the remaining elements
     * of the non-empty list is added to the solution linked list. In the worst case, the two lists have the same length
     * and alternate in lowest values, so 2*N steps are taken. The constant can be dropped, and hence O(N).
     * <p>
     * Space Complexity: O(S), where S = the sum of the lenghts of the two given lists
     * Since all the values from both of the lists must be stored, the size of the merged sorted list will be equivalent
     * to the sum of the lenghts of the two given lists.
     *
     * @param list1 the first linked list
     * @param list2 the second linked list
     * @return the sorted and merged linked list
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode solution = new ListNode();
        // pointer to solution;
        ListNode curr = solution;
        while (list1 != null && list2 != null) {
            // compare the two values, append the smaller value to solution linked list
            if (list1.val <= list2.val) {
                curr.next = new ListNode(list1.val);
                // advance the pointer on the linked list which was used
                list1 = list1.next;
            } else {
                curr.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            // advance the solution pointer
            curr = curr.next;
        }
        // check if one of the linked lists is longer than the other, append the longer one
        if (list1 == null && list2 != null) {
            curr.next = list2;
        }
        if (list1 != null && list2 == null) {
            curr.next = list1;
        }
        // return from next since first elemented inserted at next of starting node
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