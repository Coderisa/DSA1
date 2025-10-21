class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        // Dummy node to simplify edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevGroupEnd = dummy;

        while (true) {
            // Find the kth node from current position
            ListNode kth = prevGroupEnd;
            for (int i = 0; i < k && kth != null; i++) {
                kth = kth.next;
            }
            if (kth == null) break; // Not enough nodes to reverse

            // Reverse k nodes
            ListNode groupStart = prevGroupEnd.next;
            ListNode nextGroupStart = kth.next;

            // Reverse the group
            ListNode prev = nextGroupStart;
            ListNode curr = groupStart;
            while (curr != nextGroupStart) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            // Connect previous group to reversed group
            prevGroupEnd.next = kth;
            prevGroupEnd = groupStart;
        }

        return dummy.next;
    }
}
