class Solution {
    public int power(int a,int b){
        double c=Math.pow(a,b);
        return (int)c;
    }
    public int reverseExponentiation(int n) {
        // code here
        
        if(n>0 &&n<=9){
            return power(n,n);
        }
        else{
            int input=n;
            int res=0;
            while(n>0){
                int temp=n%10;
                res=res*10+(temp);
                n=n/10;
            }
            return power(input,res);
        }
       
    }
}
