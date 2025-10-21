class Solution {
    public ListNode insertionSortList(ListNode head) {
        // Dummy node acts as the new sorted list's head
        ListNode dummy = new ListNode(0);
        ListNode curr = head;

        while (curr != null) {
            // At each iteration, we insert curr into the sorted part
            ListNode prev = dummy;

            // Find the right place to insert curr
            while (prev.next != null && prev.next.val < curr.val) {
                prev = prev.next;
            }

            // Save the next node to process
            ListNode nextTemp = curr.next;

            // Insert curr between prev and prev.next
            curr.next = prev.next;
            prev.next = curr;

            // Move to the next node
            curr = nextTemp;
        }

        return dummy.next;
    }
}
