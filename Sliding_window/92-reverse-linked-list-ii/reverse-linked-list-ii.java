class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        // Step 1: Create a dummy node to handle edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // Step 2: Move prev to the node before "left"
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // Step 3: Reverse the sublist from left to right
        ListNode curr = prev.next;
        ListNode next = null;
        for (int i = left; i < right; i++) {
            next = curr.next;
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }

        return dummy.next;
    }
}
/*
Try drawing what happens in every step of the algorithm. I find this especially helpful with problems involving linked lists. Once I had a visual representation of what the reverse list algorithm did in each step (for each node), I was amazed at how simple it was. It also helps recalling the algorithm later as that picture gets stuck in your mind. So even if you don't recall the exact algo, you can still come up with it at the spot.*/