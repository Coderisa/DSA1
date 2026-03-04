import java.util.*;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int m = spells.length;
        int n = potions.length;

        // Sort potions so we can binary search
        Arrays.sort(potions);
        int maxPotion = potions[n - 1];

        int[] answer = new int[m];

        for (int i = 0; i < m; i++) {
            int spell = spells[i];
            long minPotion = (long) Math.ceil((1.0 * success) / spell);

            // If even the strongest potion can't meet the requirement
            if (minPotion > maxPotion) {
                answer[i] = 0;
                continue;
            }

            // Find the first potion >= minPotion
            int index = lowerBound(potions, (int) minPotion);
            answer[i] = n - index;
        }

        return answer;
    }

    // Custom binary search to find lower bound
    private int lowerBound(int[] arr, int target) {
        int l = 0, r = arr.length;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }
}

/*
class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int pairs[]=new int[spells.length];
        Arrays.sort(potions);
        for(int i=0;i<=spells.length-1;i++){
            int l=0,e=potions.length-1,c=0;//variable c might not have been initialized
            while(l<=e)
            {
               int mid=l+(e-l)/2;
               if( (long)spells[i] *(long) potions[mid]>= success){
                 //c=potions.length-mid;
                 e=mid-1;}
                 else 
                l=mid+1; 
            }
            //pairs[i]=c;
            pairs[i]=potions.length-l;            
        }
        return pairs;
    }
}
*/