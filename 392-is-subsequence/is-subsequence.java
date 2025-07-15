class Solution {
    public boolean isSubsequence(String s, String t) {
        int i=0,j=0,count=0, n=s.length(), m=t.length();
        while(i< n && j< m){
            if(s.charAt(i)!= t.charAt(j))
              j++;
            else
              {
                i++;j++;count++;
              }  
        }
        if (count == s.length())
          return true;
        else 
        return false;
    } 
} 
        /*
        HashMap<Character,Integer>mp=new HashMap<>();
        int c=0;
        for(int j=0;j<t.length();j++){
          char  i=t.charAt(j);
            mp.put(i,j);
        
        }
        int k=-1;
        for(int j=0;j<s.length();j++){
            char i=s.charAt(j);
            if(mp.containsKey(i) && (mp.get(i)-k>0) )
              k=mp.get(i);
            else
              return false;  
        }
        return true;
    }
} */