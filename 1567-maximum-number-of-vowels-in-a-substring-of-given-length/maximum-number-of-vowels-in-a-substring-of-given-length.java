class Solution {
    public int maxVowels(String s, int k) {
        int j=0, c=0, max=0;
        while(j < k){
            if(isVowel( s.charAt(j) ) )
              c++;
              max=Math.max(max,c);
            j++;  
            }
          if( c==k) return c;
        for( j=k; j< s.length(); j++){

            //remove left most character freq from c if vowel
            if (isVowel(s.charAt(j-k)) ) c--;

            // do c++ if new character at j is a vowel
            if(isVowel(s.charAt(j)) )  c++;

            if(c == k)
              return c;
             max=Math.max(max,c);
        }
        return max;  
       
    }
     boolean isVowel(char n) 
        {
            if( n=='a' || n=='e' || n=='i'|| n=='o'|| n=='u')
             return true;
            else
             return false;
        }
}