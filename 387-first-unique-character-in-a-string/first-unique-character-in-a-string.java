class Solution {
     public int firstUniqChar(String s) {
        // Stores lowest index / first index
        int ans = Integer.MAX_VALUE;
        // Iterate from a to z which is 26 which makes it constant
        for(char c='a'; c<='z';c++){
            // indexOf will return first index of alphabet and lastIndexOf will return last index
            // if both are equal then it has occured only once.
            // through this we will get all index's which are occured once
            // but our answer is lowest index
            int index = s.indexOf(c);
            if(index!=-1&&index==s.lastIndexOf(c)){//if it exist and only once
                ans = Math.min(ans,index);//finding out the fits elemnt that occcurs once
            }
        }

        // If ans remain's Integer.MAX_VALUE then their is no unique character
        return ans==Integer.MAX_VALUE?-1:ans;
    }   
} /*-isme agar length10^5 hui tab O(10^5)+O(10^5)-<in worst case
class Solution {
    public int firstUniqChar(String s) {
        //bina ek baar traverse kare bina to mughe nhi pta chale ga ki kon sa elemnt aisa hai jpo repeat nhi hua hai
        HashMap<Character,Integer>mp=new HashMap <>();
        for(int i=0;i<s.length();i++)
          mp.put(s.charAt(i),mp.getOrDefault(s.charAt(i),0)+1);//1 ka matlb hai ki sirf ek baar aya hai
       
        for(int i=0;i<s.length();i++){
          if (mp.get(s.charAt(i))==1)  
          return i;}
          return -1;
    }
}*/