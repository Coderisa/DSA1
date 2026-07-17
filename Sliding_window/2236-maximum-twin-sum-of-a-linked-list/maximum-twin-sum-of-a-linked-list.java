/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
 /*
class Solution {
    public int pairSum(ListNode head) {
        //find the middle of the list then traverse from there
        ListNode slow= head; ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        //now slow points at the middle of the Linked List
        ArrayList<Integer> adj=new ArrayList<>();
        ListNode curr= head;
        while(curr!=slow){
            adj.add(curr.val);
        }
        int l= adj.size() -1, max=Integer.MIN_VALUE, sum=0;
        while(slow!=null){
            sum= slow.val+ adj.get(l);
            max=Math.max(max,sum);
            l--;
        }
        return max;
    }
}
*/

class Solution {
    public int pairSum(ListNode head) {
        //find the middle of the list then traverse from there
        ListNode slow= head; ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        //now slow points at the middle of the Linked List
        Stack<Integer>adj= new Stack<>();
        ListNode curr= head;
        while(curr!=slow){
            adj.push(curr.val);
            curr= curr.next;
        }
        int l= adj.size() -1, max=Integer.MIN_VALUE, sum=0;
        while(slow!=null){
            sum= slow.val+ adj.pop();
            max=Math.max(max,sum);
            slow=slow.next;
            
        }
        return max;
    }
}
