//SLIDING WINDOW OPTIMIZED
class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int i =0, maxF=0,maxT=0, f=0;
        
        for(int j =0;j< answerKey.length();j++){
            if (answerKey.charAt(j) == 'F') f++;
            while( f>k){
                if(answerKey.charAt(i) == 'F')f--;
                i++;

            }
            maxT = Math.max(maxT, j -i+1);
        }
        f=0;i=0;
        for(int j =0;j< answerKey.length();j++){
            if (answerKey.charAt(j) == 'T') f++;
            while( f>k){
                if(answerKey.charAt(i) == 'T')f--;
                i++;

            }
            maxF = Math.max(maxF, j -i+1);
        }
        return Math.max(maxT,maxF);
    }
}

//BRUTE FORCE

class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        // Find the maximum length we can get by changing to 'T'
        int maxT = findMaxForChar(answerKey, k, 'T');
        // Find the maximum length we can get by changing to 'F'
        int maxF = findMaxForChar(answerKey, k, 'F');
        
        // Return the larger of the two
        return Math.max(maxT, maxF);
    }

    private int findMaxForChar(String answerKey, int k, char target) {
        int n = answerKey.length();
        int maxLen = 0;
        
        // Try every possible start point for the substring
        for (int i = 0; i < n; i++) {
            int changesNeeded = 0;
            
            // Try every possible end point for the substring starting at 'i'
            for (int j = i; j < n; j++) {
                // If the character is not our target, we would need to change it
                if (answerKey.charAt(j) != target) {
                    changesNeeded++;
                }
                
                // If the number of changes needed is within the limit, we have a valid substring
                if (changesNeeded <= k) {
                    int currentLength = j - i + 1;
                    maxLen = Math.max(maxLen, currentLength);
                } else {
                    // If we exceed k, there's no point in extending this substring further
                    // We can break the inner loop and try a new start point
                    break;
                }
            }
        }
        return maxLen;
    }
}


/*
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


*/
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

