class Solution {
   
    static void rotateby90(int mat[][]) {
        // code here
        int n=mat.length;


        
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                    int temp=mat[i][j];
                    mat[i][j]=mat[j][i];
                    mat[j][i]=temp;
            }
        }
        
        for(int i=0;i<n;i++){
            int l=0,r=n-1;
            while(l<r){
                int temp=mat[l][i];
                mat[l][i]=mat[r][i];
                mat[r][i]=temp;
                l++;
                r--;
            }
           
        }
        
    }
}
