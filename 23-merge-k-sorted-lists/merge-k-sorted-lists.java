import java.util.PriorityQueue;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        // Min-heap based on node values
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add all non-null list heads to the priority queue
        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }

        // Dummy head for result list
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (!pq.isEmpty()) {
            ListNode curr = pq.poll(); // Get the smallest node
            tail.next = curr;
            tail = tail.next;

            if (curr.next != null) {
                pq.offer(curr.next); // Add next node from the same list
            }
        }

        return dummy.next;
    }
}
