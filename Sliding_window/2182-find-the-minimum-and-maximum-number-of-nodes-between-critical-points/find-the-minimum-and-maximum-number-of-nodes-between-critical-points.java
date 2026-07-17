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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if(head==null|| head.next==null|| head.next.next==null) return new int[]{-1,-1};
        //now there exits atleast 3 nodes in the array
        ListNode curr= head.next;
        ListNode prev=head;
        int p=1, min =Integer.MAX_VALUE;
        ArrayList<Integer>adj=new ArrayList<>();

        while(curr!=null && curr.next!=null){
            if ((curr.val> prev.val && curr.val > curr.next.val)|| 
            (curr.val< prev.val && curr.val < curr.next.val) ){
             
              if(adj.size()>=1) 
                 min=Math.min(min, p-adj.get(adj.size()-1));

              adj.add(p);
            }
            p++;
            prev=curr;
            curr=curr.next;
        }
        int ans[]=new int[2];
        if(adj.size()< 2) return new int[]{-1, -1};
        ans[0]= min;
        ans[1]= adj.get(adj.size() -1) - adj.get(0);
        return ans;

    }
}