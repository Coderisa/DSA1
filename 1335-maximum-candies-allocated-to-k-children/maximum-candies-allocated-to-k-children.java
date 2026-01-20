class Solution {
    public int maximumCandies(int[] candies, long k) {
        int l=1 ;int h=Integer.MIN_VALUE;
        for(int c : candies){
          h=Math.max(c,h);
        }
        int r=0;
      
        while(l<= h){
            int mid= l+(h-l)/2;
            if(isPossible(candies,k,mid)){
                r=mid;
                l=mid+1;
            }
            else{
                h=mid-1;
            }

        }
        return r;
    }

   boolean isPossible(int[] candies, long k, int n){
    long s=0;
     for( int c:candies){
        s+=(c/n);
        if(s>=k) return true;
     }
     return s>=k;
   }

}