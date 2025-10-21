class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        // Step 1: Get the length of the list
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }

        // Dummy node to simplify edge cases
        ListNode dummy = new ListNode(0, head);

        // Step 2: Bottom-up merge sort
        for (int size = 1; size < length; size <<= 1) {
            ListNode prev = dummy;
            ListNode curr = dummy.next;

            while (curr != null) {
                // Split left and right sublists
                ListNode left = curr;
                ListNode right = split(left, size);
                curr = split(right, size);

                // Merge and attach to prev
                prev.next = merge(left, right);

                // Move prev to the end of the merged sublist
                while (prev.next != null) {
                    prev = prev.next;
                }
            }
        }

        return dummy.next;
    }

    // Splits the list into two parts, returns the head of the second part
    private ListNode split(ListNode head, int size) {
        for (int i = 1; head != null && i < size; i++) {
            head = head.next;
        }
        if (head == null) return null;

        ListNode second = head.next;
        head.next = null;
        return second;
    }

    // Merges two sorted lists
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        tail.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }
}
