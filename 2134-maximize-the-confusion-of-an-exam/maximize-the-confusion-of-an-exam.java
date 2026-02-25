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


