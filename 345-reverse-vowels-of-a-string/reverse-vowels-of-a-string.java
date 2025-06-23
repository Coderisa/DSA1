class Solution {
    public String reverseVowels(String s) {
        boolean[] vowels = new boolean[128];//Default all values false
        for (char c : "aeiouAEIOU".toCharArray()) {
            vowels[c] = true;//'a' has ASCII code 97, so vowels[97] = true;
        }
        char[] c = s.toCharArray();
        int i = 0, j = c.length - 1;
        while (i < j) {
            while (i < j && !vowels[c[i]]) {
                ++i;
            }
            while (i < j && !vowels[c[j]]) {
                --j;
            }
            if (i < j) {
                char t = c[i];
                c[i] = c[j];
                c[j] = t;
                ++i;
                --j;
            }
        }
        return String.valueOf(c);
    }
}
/* int[] → default values are 0

char[] → default values are '\u0000' (null character)

double[] → default values are 0.0
*/
/*class Solution {
    public String reverseVowels(String s) {
        StringBuffer sb = new StringBuffer(s);
        ArrayList<Character> mp= new ArrayList<>();//Yes, the indexing of an ArrayList in Java does start from 0
        for(char i :  s.toCharArray() ){ //StringBuffer is not iterable. You cannot use an enhanced for loop (for-each) with it.
            if (i=='a' || i=='e' || i=='i' ||  i=='o' ||  i=='u' || i=='A' ||  i=='E' ||  i=='I' ||  i=='O' ||  i=='U' ) {
         mp.add(i);
       }
    }
    int size=mp.size();
    for(int i=0;i<sb.length(); i++){

    if (s.charAt(i)=='a' ||s.charAt(i)=='e' ||s.charAt(i)=='i' ||s.charAt(i)=='o' ||s.charAt(i)=='u' ||s.charAt(i)=='A' ||s.charAt(i)=='E' ||s.charAt(i)=='I' ||s.charAt(i)=='O' ||s.charAt(i)=='U' ){

          sb.setCharAt(i, mp.get(--size));//ArrayList indexing starts from 0
       }
    }
   return sb.toString();//StringBuffer to String

}
}*/
/* Anothr method to check for vowels 
public static boolean isVowel(char c) {
  return "AEIOUaeiou".indexOf(c) != -1;
}*/