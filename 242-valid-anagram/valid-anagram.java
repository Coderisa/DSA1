class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> count = new HashMap<>();
        
        // Count the frequency of characters in string s
        for (char x : s.toCharArray()) {
            count.put(x, count.getOrDefault(x, 0) + 1);
        }
        
        // Decrement the frequency of characters in string t
        for (char x : t.toCharArray()) {
            count.put(x, count.getOrDefault(x, 0) - 1);
        }
        
        // Check if any character has non-zero frequency
        for (int val : count.values()) {
            if (val != 0) {
                return false;
            }
        }
        
        return true;
    }
}
/*
//Check if 2 straings are anagram or not
//Input: s = "anagram", t = "nagaram"  Output: true
import java.util.*;
class Anagram{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("\nEnter 2 strings for anagram checking\n");
        String s1=sc.next();//for single string sc.nextLine() for string with spaces
        String s2=sc.next();
        Anagram(s1,s2);
    }
    static void Anagram(String s1,String s2){
        HashMap <Character,Integer>mp=new HashMap<>();
        int flag=0;
        if (s1.length()==s2.length() && flag==0)
        {
            for(int i=0;i<s1.length();i++){
                mp.put( s1.charAt(i),mp.getOrDefault(s1.charAt(i),0)+1 );//Jab koi nai string ho to usme getOrDefault likho becoz agar usme kuch nahi hua to get karne pr nullPointerException 
                //dikhta hai nahi to pahle 0 dalta hai fir +1 karta hai
            }
            for(int i=0;i<s1.length();i++){
                if (!mp.containsKey(s2.charAt(i)))
                  flag++;
                else if (mp.get(s2.charAt(i)) <=0)
                   flag++;
                else    
                mp.put (s2.charAt(i),(mp.get(s2.charAt(i)))-1 );
                
            }
        }
        if(flag==0)
          System.out.println("Anagaram Strings "+s1+" and "+s2);
          else
          System.out.println("Not ananagram strings");
          }
}
/* earlier I was doing this 
 * for(int i=0;i<s1.length();i++){
                if (mp.containsKey(s2.charAt(i)))
                mp.put (s2.charAt(i),(mp.get(s2.charAt(i))-1) ); //but isme to frq agr 0/-1/-2 hi hogi to bhi ye hashmap mein to hai hi na ex-ina ,nan mein n ki freq 0 hogi tab bhi it shows as anagram
                else 
                  flag++;//agr nhi conatin karta hai
 * 
 * 
 * /
 */

