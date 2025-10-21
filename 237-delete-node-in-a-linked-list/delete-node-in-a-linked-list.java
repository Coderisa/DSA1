class Solution {
    public void deleteNode(ListNode node) {
        // Copy the value of the next node into the current node
        node.val = node.next.val;
        // Skip the next node
        node.next = node.next.next;
    }
}
