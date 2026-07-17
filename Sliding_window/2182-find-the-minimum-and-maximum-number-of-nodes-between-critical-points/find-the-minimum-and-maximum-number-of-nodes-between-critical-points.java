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
             
              if(adj.size()>=1) //atleast1 node to hona hi chaiye tabhi you can compare.
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
*/
// A more polished version
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1};
        }

        ListNode prev = head;
        ListNode curr = head.next;
        int index = 1; // position of curr
        ArrayList<Integer> criticalPoints = new ArrayList<>();
        int minDist = Integer.MAX_VALUE;

        while (curr.next != null) {
            if ((curr.val > prev.val && curr.val > curr.next.val) ||
                (curr.val < prev.val && curr.val < curr.next.val)) {
                
                if (!criticalPoints.isEmpty()) {
                    minDist = Math.min(minDist, index - criticalPoints.get(criticalPoints.size() - 1));
                }
                criticalPoints.add(index);
            }
            prev = curr;
            curr = curr.next;
            index++;
        }

        if (criticalPoints.size() < 2) return new int[]{-1, -1};

        int maxDist = criticalPoints.get(criticalPoints.size() - 1) - criticalPoints.get(0);
        return new int[]{minDist, maxDist};
    }
}
