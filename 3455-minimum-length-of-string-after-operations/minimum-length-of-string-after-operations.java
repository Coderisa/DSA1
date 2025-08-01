class Solution{
public int minimumLength(String s) {
    Map<Character, Integer> freq = new HashMap<>();
    int del = 0;

    for (char ch : s.toCharArray()) {
        freq.put(ch, freq.getOrDefault(ch, 0) + 1);

        if (freq.get(ch) == 3) {
            freq.put(ch, 1); // reduce count by 2
            del += 2;
        }
    }

    return s.length() - del;
}}//Same soln usinh map
/*

class Solution {
    public int minimumLength(String s) {
        int freq[]=new int[26];int del=0;

for(int i=0; i< s.length(); i++){
    freq[s.charAt(i) - 'a']++;

    if(freq[s.charAt(i)-'a']==3){
        freq[s.charAt(i)-'a']-=2;
    del+=2;}
}
return (s.length()-del);
    }
} */
//OR 
        /*
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
}*/
