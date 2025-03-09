class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int ans[]=new int[A.length];//in java initialize all elemnts with 0
        HashSet<Integer>mp=new HashSet<>();
        int count ;
        for(int i=0;i<A.length;i++){
            mp.add(A[i]);
            count=0;
            for(int j=0;j<=i;j++){
                if(mp.contains(B[j]))
                  count++;
            }
        
        ans[i]=count;
        }


        return ans;
    }
}