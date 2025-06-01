import java.util.*;
class subArray{

    

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int num=0;num<n;num++){
            arr[num]=sc.nextInt();
        }
        int k=sc.nextInt();
        int tot=0,max=0;
        for(int i=0;i<n-k+1;i++){
         if(i==0){
            for(int j=0;j<k;j++)
            {
            tot+=arr[j];
         }}
         else{
            tot=tot-arr[i-1]+arr[i+k-1];
         }
        if(tot>max){
            max=tot;
        }
        }
    System.out.print(max);
    }
}