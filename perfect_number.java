
class Solution {
    static boolean isPerfectNumber(int n) {
        // code here
        int input=n,res=0;
        for(long i=1;i*i<=n;i++){
            if(n%i==0){
                if(i*i!=n){
                res+=i+(n/i);
            }
                
            }
            
        }
        if((res-n)==input){
            return true;
        }
        return false;
        
    }
}
