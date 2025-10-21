class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // 1. Interleave copied nodes with original nodes
        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        // 2. Assign random pointers to copied nodes
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // 3. Separate the copied list from the original list
        Node dummy = new Node(0);
        Node copyCurr = dummy;
        curr = head;
        while (curr != null) {
            Node copy = curr.next;
            copyCurr.next = copy;
            copyCurr = copy;

            curr.next = copy.next; // restore original list
            curr = curr.next;
        }

        return dummy.next;
    }
}
