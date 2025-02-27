class Solution {
    boolean Solve(String s,int i,int j) {      
            if(i>=j)
             return true;
            if(s.charAt(i)==s.charAt(j))
               return Solve(s,i+1,j-1);
            else
               return false;   
        }
    public String longestPalindrome(String s) {
       int n=s.length();
        //Check Palindrome string fn 
     
        int maxLen=0;
        int sp=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                  
                  if (Solve(s,i,j)==true){
                    if(j-i+1>maxLen){
                        maxLen=j-i+1;
                        sp=i;
                    }
                  }
            }
        }
        return s.substring (sp,maxLen+sp);
    }
}