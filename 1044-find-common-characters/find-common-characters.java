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
}/*REMBER TO WRITE THE  int freq[] = new int[26]; INSIDE THE FOR LOOP!
Note-The JVM allocates a new array object on the heap every iteration.

That object contains 26 int slots, each set to 0 — the default for primitive types.

The old array isn’t cleared manually — it just goes out of scope and the reference disappears (unless you’ve stored it somewhere else).

The loop’s reference freq now points to a completely new array.

TIME COMPLEXITY-O(n * k + c)
n be the number of words

k be the average length of each word

c be the number of characters ultimately added to the result*/
       