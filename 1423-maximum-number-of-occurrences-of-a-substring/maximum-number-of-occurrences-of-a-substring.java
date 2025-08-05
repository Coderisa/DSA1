class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String,Integer>map=new HashMap<>();
        int i=0, j=0, res=0, freq[]=new int[26];
        while( j< s.length()){
            if(++freq[s.charAt(j++) - 'a'] == 1)
            --maxLetters;
              while(maxLetters < 0 || j - i > minSize)//more than required alphabets in the window or substring length greater than minSize
            if(--freq[s.charAt(i++) - 'a'] == 0)//deleted last occurence from the window
                ++maxLetters;

        if(j - i == minSize)
            res = Math.max(res, map.merge(s.substring(i, j), 1, Integer::sum));//store the largest count
    }
    return res;
        }
    }
