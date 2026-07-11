/*class Solution {
    public boolean isValid(String s) {
        if (s.length()%2!=0) return false;
       Stack <Character> st=new Stack<>();
       
       for(int i=0;i<s.length();i++){
         char ch=s.charAt(i);

         if(ch=='('|| ch=='{'|| ch=='[')
           st.push(ch);

         else{
            
            if(st.size()==0) return false; // } {} //EmpltyStackException if this line is missed
             char t=st.peek();
             if (( t== '(' && ch == ')') || (t == '[' && ch == ']') || (t == '{' && ch == '}')) {
                    st.pop();
                } 
            else return false;  //Invalid input
         }  
       }
          return st.isEmpty();
       
    }
}*/
/*
else{
                if(stack.isEmpty()) return false;
                char temp = stack.pop();
                if(ch == ')' && temp != '(') return false;
                if(ch == '}' && temp != '{') return false;
                if(ch == ']' && temp != '[') return false;
            }
*/ 
class Solution {
    public boolean isValid(String s) {
        if (s.length()%2!=0) return false;
       Stack <Character> st=new Stack<>();

       for(int i=0;i<s.length();i++){
         char ch=s.charAt(i);

         if(ch=='('|| ch=='{'|| ch=='[')
           st.push(ch);

         else{
             if(st.isEmpty()) return false;
       char temp = st.pop();
                if(ch == ')' && temp != '(') return false;
                if(ch == '}' && temp != '{') return false;
                if(ch == ']' && temp != '[') return false;
            }
       }
         return st.isEmpty();
    }
}