class Solution {
    public void reverseString(char[] s) {
        //Modify in-place: You need to update or change the elements of the original array without using a separate array or any additional data structures to store the results.
    //O(1) extra memory: The term "O(1)" is Big O notation that signifies constant space complexity.
    int p=s.length-1;
    for(char i=0;i<s.length/2 ;i++){
        char temp=s[i];
        s[i]=s[p];
       s[p--]=temp;
    }
    }
}