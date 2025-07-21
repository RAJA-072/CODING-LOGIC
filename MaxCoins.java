import java.util.*;
public class MaxCoins {

    public static void findMax(int coins[][],int box,int r,int c ){
        int prefixsum[][]=new int [r][c+1];
        for(int i=0;i<r;i++){
            for(int j=1;j<=c;j++){
                prefixsum[i][j]=prefixsum[i][j-1]+coins[i][j-1];    //prefixsum
            }
        }

        int dp[]=new int[box+1];
        for(int i=0;i<r;i++){
            for(int j=box;j>=0;j--){
                for(int k=1;k<=c && k<=j;k++){
                    dp[j]=Math.max(dp[j],dp[j-k]+prefixsum[i][k]);
                }
            }
        }
        System.out.println(dp[box]);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt();
        
        for(int i=0;i<N;i++){
            int r=sc.nextInt();
            int c=sc.nextInt();
            int box=sc.nextInt();
            int coins[][]=new int[r][c];
            
            for(int row=0;row<r;row++){
                for(int col=0;col<c;col++){
                    coins[row][col]=sc.nextInt();
                }
            }
            findMax(coins,box,r,c);
        }
    }
}
