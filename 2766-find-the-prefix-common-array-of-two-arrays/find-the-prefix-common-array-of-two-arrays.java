class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
    HashMap<Integer,Integer>mp=new HashMap<>();
    int ans[]=new int[A.length];
    int count=0;
    for(int i=0;i<A.length;i++){
        if(!mp.containsKey(A[i]))
          mp.put(A[i],mp.getOrDefault(A[i],0)+1);
           else count++;//B ne pahle se daal diya hai
        if(!mp.containsKey(B[i]))
          mp.put(B[i],mp.getOrDefault(B[i],0)+1);
           else count++; //A ne pahle se daal diya hai
        ans[i]=count;
    }
    return ans;
    }
}
//or
/*
Set<Integer> set = new HashSet<>();
        int[] res = new int[A.length];
        for(int i = 0; i<A.length; i++){
            set.add(A[i]);
            set.add(B[i]);
            res[i] = 2*(i+1) - set.size();
        }
        return res;
*/

      //Brute
        /*int ans[]=new int[A.length];//in java initialize all elemnts with 0
        HashSet<Integer>mp=new HashSet<>();
        int count ;
        for(int i=0;i<A.length;i++){
            mp.add(A[i]);
            count=0;
            for(int j=0;j<=i;j++){
                if(mp.contains(B[j]))
                  count++;
            }
        
        ans[i]=count;
        }


        return ans;
    }
}*/