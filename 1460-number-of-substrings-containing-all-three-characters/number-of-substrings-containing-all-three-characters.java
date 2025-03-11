class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();

        int result = 0;

        int[] mp = new int[3]; // 0 - a, 1 - b, 2 - c -->java automatically assigns 0 

        int i = 0;
        int j = 0;

        while (j < n) {
            char ch = s.charAt(j);
            mp[ch - 'a']++; //a-97,b-98,c-99

            while (mp[0] > 0 && mp[1] > 0 && mp[2] > 0) {
                result += (n - j);

                mp[s.charAt(i) - 'a']--;
                i++;//moving the sliding window ahead
            }

            j++;
        }

        return result;
    }
}
