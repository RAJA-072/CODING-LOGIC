
class Solution {
    boolean twoSum(int arr[], int target) {
        // code here
        Arrays.sort(arr);
        int l=0;
        int r=arr.length-1;
        if(arr[0]>target){
            return false;
        }
        while(l<r){
            int val=arr[l]+arr[r];
            if(arr[l]+arr[r]==target){
                return true;
            }
            else if(val>target){
                r--;
            }
            else{
                l++;
            }
                
        }
    
        return false;
    }
}
