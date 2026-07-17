
class Solution {
    public ListNode swapPairs(ListNode head) {
        // Dummy node to simplify edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;

        while (head != null && head.next != null) {
            // Nodes to be swapped
            ListNode first = head;
            ListNode second = head.next;

            // Swapping
            prev.next = second;
            first.next = second.next;
            second.next = first;

            // Re-positioning for next swap
            prev = first;
            head = first.next;
        }

        return dummy.next;
    }
} 
/* MY ATTEMPT
Realized that I needed 2 nodes first , second(first se pahle), prev(second se pahli) like in case of revering 2-->4 ke liye prev node is required.
Also dummy node is needed as dummy.next= head; as head changes too so as to keep track ki jo bhi node dummy ke baad ayega vhi head hoga.
class Solution {
    public ListNode swapPairs(ListNode head) {
        Listnode curr= head;
        Listnode prev= null;
        Listnode pahle=null;
        int p=1;
        while(curr!=null){
            if(p%2 !=0){
                prev=curr;
                curr= curr.next;
            }
            else{
                
                prev.next=curr.next;
                curr.next=prev;

                curr=prev.next;
            }
            prev=curr;
            p++;
        }
    }
}
*/