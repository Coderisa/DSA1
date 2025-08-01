class Solution {
    public int minimumLength(String s) {
        int freq[]=new int[26];
        int r=0;
        for(char ch: s.toCharArray())
           freq[ch - 'a']++;

        for(int i=0;i<26;i++){
            if(freq[i]==0)continue;
            if(freq[i]%2==0)r+=2;
            else 
            r+=1;

        }   
        return r;
    }
}