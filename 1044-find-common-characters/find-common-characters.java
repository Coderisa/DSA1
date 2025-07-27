class Solution {
    public List<String> commonChars(String[] words) {
        //can't use hashmap as it will increase the time complexity
        //words[i].length can be 100 and these can be 100 words in the array
        
     int minFreq[]=new int[26];
        Arrays.fill(minFreq, Integer.MAX_VALUE);

       
           for(String s:words){
               int freq[] = new int[26];

                for (char ch : s.toCharArray()) {
                freq[ch - 'a']++;
            }//freq array for 1 word or 1 single string s
        
        // Update minFreq to hold the minimum frequency found in all strings
        for (int i = 0; i < 26; i++) {
                minFreq[i] = Math.min(minFreq[i], freq[i]);
            }

           }//for

           List<String> result = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < minFreq[i]; j++) {
                result.add(String.valueOf((char) (i + 'a')));
            }
        } return result;
        }
}
       