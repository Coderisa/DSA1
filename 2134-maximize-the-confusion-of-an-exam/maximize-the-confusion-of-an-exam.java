//T- o(N)
//S-o(1)-->CONSTAT AS ONLY 2 VARIABLES ARE USED T &F
//faster approach as it avoids map overhead
class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int i= 0, j=0, countF=0, countT=0, max=0;
        while( j < answerKey.length()){
            if (answerKey.charAt(j) == 'F') countF++;

            while(countF > k){
                if (answerKey.charAt(i) == 'F') countF--;
                i++;
            }
            max=Math.max(max, j-i+1);
            j++;
        }
  i= 0; j=0;
         while( j < answerKey.length()){
            if (answerKey.charAt(j) == 'T') countT++;

            while(countT > k){
                if (answerKey.charAt(i) == 'T') countT--;
                i++;
            }
            max=Math.max(max, j-i+1);
            j++;
        }
        return max;
    }
}
/*
class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        HashMap<Character , Integer> mp =new HashMap<>();
        int i=0 , j=0, max =0;
        for(j=0; j< answerKey.length();j++){
           char ch = answerKey.charAt(j); 
           mp.put(ch, mp.getOrDefault(ch, 0) + 1);

           while (Math.min(mp.getOrDefault('T', 0), mp.getOrDefault('F', 0)) > k) {
    char left = answerKey.charAt(i);
    mp.put(left, mp.get(left) - 1);
    i++;
}
             max=Math.max(max, j-i+1);
        }//for
        return max;
    }
}
------------------------------------------------------------------------------
//Approach-1 (Simple Brute Force) - O(n * 2^n)
class Solution {
public:
    int ans = 0;
    int n;
    
    void findMax(string answerKey) {
        int length = 0;
        
        int i = 0;

        while(i < n) {
            
            if(answerKey[i] == 'T') {
                length = 1;
                i++;
                while(i < n && answerKey[i] == 'T') {
                    length++;
                    i++;
                }
                ans = max(ans, length);
            } else {
                length = 1;
                i++;
                while(i < n && answerKey[i] == 'F') {
                    length++;
                    i++;
                }
                ans = max(ans, length);
            }
            
        }
    }
    

*/



