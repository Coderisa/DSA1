class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int e= letters.length-1;int b=0;char c=letters[0];
        while(b<=e){
            int mid=(b+e)/2;
            if (letters[mid] > target){
                  c=letters[mid];
                  e=mid-1;
            }
            else {
                b= mid+1;
            }
        }
        return c;
    }
}