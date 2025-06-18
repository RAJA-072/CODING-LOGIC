import java.util.*;
public class hospitalDistance {
    

    public static boolean isPossible(int[] dist,int n,int maxdist){
        int count=0;
        for(int i=1;i<dist.length;i++){
            int distance=dist[i]-dist[i-1];
            count+=(distance-1)/maxdist;
        }
        return count<=n ;
    }
    public static void maxDist(int dist[],int n){
        int l=1;
        int h=dist[dist.length-1]-dist[0];
        while(l<h){
            int mid=(l+h)/2;
            if(isPossible(dist,n,mid)){
                h=mid;
            }
            else{
                l=mid+1;
            }
        }
        System.out.print(h);
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<N;i++){
            int n=sc.nextInt();
            int h=sc.nextInt();
            sc.nextLine();
            int dist[]=new int[n];
            for(int j=0;j<n;j++){
                   dist[j]=sc.nextInt();
            }
            maxDist(dist,h);
        }
        
    }
}
