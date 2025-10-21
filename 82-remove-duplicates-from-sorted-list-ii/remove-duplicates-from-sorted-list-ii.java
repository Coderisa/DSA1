class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // Dummy node to handle edge cases like duplicates at the head
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;

        while (head != null) {
            // Detect duplicates
            if (head.next != null && head.val == head.next.val) {
                int duplicateVal = head.val;
                // Skip all nodes with the duplicate value
                while (head != null && head.val == duplicateVal) {
                    head = head.next;
                }
                prev.next = head; // Link to the next distinct node
            } else {
                prev = head;
                head = head.next;
            }
        }

        return dummy.next;
    }
}
