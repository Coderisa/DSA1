public class Solution {
    public String reverseWords(String s) {
        // Trim the input string to remove leading and trailing spaces
        s = s.trim();

        
        StringBuilder result = new StringBuilder();
        int end = s.length();

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                end = i;
            } else if (i == 0 || s.charAt(i - 1) == ' ') {
                if (result.length() > 0) result.append(" ");
                result.append(s.substring(i, end));
            }
        }

        return result.toString();
    }
}

 /*
        // Split the string by one or more spaces using regex
        String[] words = s.split("\\s+");//["hello", "world"]

        // Reverse the array of words
        StringBuilder reversed = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i != 0) {
                reversed.append(" ");
            }
        }

        // Convert StringBuilder to String and return
        return reversed.toString();
    }
}
*/
/*
 String[] strArr = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = strArr.length -1; i>= 0; i--) {
            sb.append(strArr[i] + " ");
        }
        return sb.toString().trim();
*/
/*
\\s → This represents any whitespace character. That includes:

space ' '
tab \t
newline \n
carriage return \r, etc.

+ → This means "one or more" of the preceding element. So "\\s+" matches:

a single space (" ")
multiple spaces (" ")
a mix of tabs and spaces ("\t ")

*/
