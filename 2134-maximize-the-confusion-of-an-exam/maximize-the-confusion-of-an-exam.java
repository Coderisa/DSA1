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

            while(Math.min ( mp.get('T'), mp.get('F') ) >k){
             char left = answerKey.charAt(i);
              mp.put(left, mp.get(left) - 1);
                i++;
            }

             max=Math.max(max, j-i+1);
        }//for
        return max;
    }
}
*/
