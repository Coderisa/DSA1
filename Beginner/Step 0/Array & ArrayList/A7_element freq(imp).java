//VVVImp revise
//Count frequency of each element
//Arrays.fill: This is a static method from the Arrays class in Java. It's designed to efficiently fill an array with a specific value.
import java.util.Arrays;
public class MyClass {
    public static void main(String args[]) { 
     int [] arr={2,3,4,5,2,3};
     int n=arr.length;
     boolean [] vis=new boolean[n];//vis is the name of boolean array
     Arrays.fill(vis,false);//Arrays.fill: This is a static method from the Arrays class in Java. 
      //It's designed to efficiently fill an array with a specific value.Here all values of vis named boolean array will be filled with false

      for(int i=0;i<n;i++){
         if(vis[i]==false){
             vis[i]=true;
             int count=1;
             for(int j=i+1;j<n;j++){
                 if(arr[i]==arr[j]){
                     vis[j]=true;
                     count++;
                 }
             }
             System.out.println(arr[i]+"->"+count);
         }
     }
    }
}
