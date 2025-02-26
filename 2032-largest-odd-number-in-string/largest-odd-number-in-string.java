/*class Solution {
    public String largestOddNumber(String num) {
      int l=num.length();int f=0;
      int i=l-1;
      while (i>=0)  {
      if( (int)(num.charAt(i)%2)!=0)
      { //odd no
      f++;
      return (num.substring(0,i+1));
      }
      else 
      i--;
      }//while
      
      return  "";
    }
}*/

class Solution {
    public String largestOddNumber(String num){
        int n=num.length()-1;
        for(int i=n;i>=0;i--){
            if  ( Character.getNumericValue(num.charAt(i))%2 !=0) //((num.charAt(i)%2)!=0) 
             return num.substring(0,i+1);
        }
        return "";
    }
}
 
