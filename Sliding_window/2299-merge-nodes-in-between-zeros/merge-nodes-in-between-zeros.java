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
class Solution {
    public ListNode mergeNodes(ListNode head) {

        ListNode neww= null; ListNode newcurr= null;
        ListNode curr= head.next;
        int sum=0;
        while(curr!=null){
           if(curr.val!=0){
            sum+=curr.val;
           }
           else{
            if(neww == null){
               neww = new ListNode(sum);
               newcurr= neww;}
            else{
                newcurr.next=new ListNode(sum);
                newcurr=newcurr.next;
            }
               
           sum=0;  }
           curr= curr.next;

        }//while
        newcurr.next= null;
        return neww;
    }
}