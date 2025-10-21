class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // Step 1: Compute the length of the list
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Step 2: Normalize k to avoid extra rotations
        k = k % length;
        if (k == 0) return head;

        // Step 3: Make the list circular
        tail.next = head;

        // Step 4: Find the new tail (length - k steps from head)
        ListNode newTail = head;
        for (int i = 0; i < length - k - 1; i++) {
            newTail = newTail.next;
        }

        // Step 5: Break the circle and set new head
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}
