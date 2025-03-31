class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int pairs[]=new int[spells.length];
        Arrays.sort(potions);
        for(int i=0;i<=spells.length-1;i++){
            int l=0,e=potions.length-1,c=0;//variable c might not have been initialized
            while(l<=e)
            {
               int mid=l+(e-l)/2;
               if( (long)spells[i] *(long) potions[mid]>= success){
                 //c=potions.length-mid;
                 e=mid-1;}
                 else 
                l=mid+1; 
            }
            //pairs[i]=c;
            pairs[i]=potions.length-l;            
        }
        return pairs;
    }
}