import java.util.*;

public class Solution {
   public int f(int n,int heights[],int k){
       int min=Integer.MAX_VALUE;
       if(n==0)return 0;
       for(int i=1;i<=k;i++){
          if(n-i>=0){
              int step=f(n-i,heights,k)+Math.abs(heights[n]-heights[n-i]);
              if(step<min){min=step;}
             
          }
        
       }
       return min;
   }
    public int frogJump(int[] heights,int k) {
       return f(heights.length-1,heights,k);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example test case
        int[] heights = {30, 10, 60, 10, 60, 50};
        int k=5;
        int result = sol.frogJump(heights,k);
        System.out.println("Minimum cost for frog to reach last stone: " + result);
    }
}
