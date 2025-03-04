class Solution {
    public int firstUniqChar(String s) {
        //bina ek baar traverse kare bina to mughe nhi pta chale ga ki kon sa elemnt aisa hai jpo repeat nhi hua hai
        HashMap<Character,Integer>mp=new HashMap <>();
        for(int i=0;i<s.length();i++)
          mp.put(s.charAt(i),mp.getOrDefault(s.charAt(i),0)+1);//0 ka matlb hai ki sirf ek baar aya hai
        for(int i=0;i<s.length();i++){
          if (mp.get(s.charAt(i))==1)  
          return i;}
          return -1;
    }
}