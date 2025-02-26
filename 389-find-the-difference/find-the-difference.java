class Solution {
    public char findTheDifference(String s, String t)
     {
    int l=t.length();
    char p,q;int m=0,su=0;
      
    for (int i=0;i<=l-2;i++)
    {
        q=s.charAt(i);
        m+=q;
        p=t.charAt(i);
        su+=p;
    }
    su=su+t.charAt(l-1);
    
    
    return (char)(su-m);

    }
}