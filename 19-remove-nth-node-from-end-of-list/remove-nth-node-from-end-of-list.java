
 class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Create a dummy node to simplify edge cases (like removing the head)
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        // Move fast pointer n+1 steps ahead so there's a gap of n between fast and slow
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Move both pointers until fast reaches the end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Skip the nth node from the end
        slow.next = slow.next.next;

        return dummy.next;
    }
}
