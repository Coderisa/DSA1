 /*class Solution {
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
}*/
/*
Try drawing what happens in every step of the algorithm. I find this especially helpful with problems involving linked lists. Once I had a visual representation of what the reverse list algorithm did in each step (for each node), I was amazed at how simple it was. It also helps recalling the algorithm later as that picture gets stuck in your mind. So even if you don't recall the exact algo, you can still come up with it at the spot.*/


/*
class Solution {
    
    // ==================== APPROACH 1: Iterative In-Place Reversal ====================
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        
        // Move 'prev' to the node just before the 'left' position
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }
        
        ListNode curr = prev.next; // first node of the sublist to reverse
        
        // Perform the reversal of the sublist [left, right]
        for (int i = 1; i <= right - left; i++) {
            ListNode temp = prev.next;          // store the first node of the reversed part (initially left)
            prev.next = curr.next;              // skip the current node
            curr.next = curr.next.next;         // advance curr's next pointer
            prev.next.next = temp;              // attach the stored node after the new first node
        }
        
        return dummy.next;
    }
}
*/
  /*
    
    // ==================== APPROACH 2: Recursive Reversal + Boundary Adjustment ====================
    // Helper to reverse nodes from 'head' up to (and including) 'rightNode'
    class Solution{
    private ListNode reverse(ListNode head, ListNode rightNode) {
        if (head == null || head.next == null || head == rightNode) {
            return head;
        }
        ListNode last = reverse(head.next, rightNode);
        head.next.next = head;
        head.next = null;
        return last;
    }
    
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode leftNode = null;
        ListNode leftPrev = null;
        ListNode rightNode = null;
        ListNode rightNext = null;
        
        ListNode curr = head;
        int count = 1;
        
        // Find leftPrev and leftNode
        while (count < left) {
            leftPrev = curr;
            curr = curr.next;
            count++;
        }
        leftNode = curr;
        
        // Find rightNode
        while (count < right) {
            curr = curr.next;
            count++;
        }
        rightNode = curr;
        rightNext = rightNode.next;
        
        // Reverse the sublist [leftNode, rightNode]
        ListNode newHead = reverse(leftNode, rightNode);
        
        // Adjust connections
        if (leftPrev != null && leftPrev.next != null) {
            // The reversed part's tail (originally leftNode) now points to rightNext
            leftPrev.next.next = rightNext;
            leftPrev.next = newHead;
        } else {
            // left == 1, so the original head is inside the reversed part
            head.next = rightNext;   // original head (leftNode) now points to rightNext
            head = newHead;          // new head is the reversed head
        }
        
        return head;
    }
    }
    
    */
    class Solution{
    
    // ==================== APPROACH 3: Using a Stack (One Pass) ====================
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) {
            return head;
        }
        
        java.util.Stack<ListNode> stack = new java.util.Stack<>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        
        // Move 'prev' to the node before 'left'
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }
        
        // Push nodes from left to right onto the stack
        ListNode curr = prev.next;
        for (int i = left; i <= right; i++) {
            stack.push(curr);
            curr = curr.next;
        }
        
        // The node that comes after the reversed sublist
        ListNode rightNext = stack.peek().next;
        
        // Pop from stack and link them in reversed order
        while (!stack.isEmpty()) {
            prev.next = stack.pop();
            prev = prev.next;
        }
        
        // Connect the tail of the reversed part to the remaining list
        prev.next = rightNext;
        
        return dummy.next;
    }
}
