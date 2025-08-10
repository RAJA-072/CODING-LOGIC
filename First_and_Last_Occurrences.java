

class GFG {
    ArrayList<Integer> find(int arr[], int x) {
        
        int l=0;
        int r=arr.length-1;
        int min=-1,max=-1;
        ArrayList<Integer> list =new ArrayList<>();
        
        while(l<=r){
            int mid=l+(r-l)/2;
            if(arr[mid]==x){
                int i=mid;
                while(i>=0){
                    if(arr[i]==x){
                        min=i;
                    }
                    else{
                        break;
                    }
                    i--;
                }
                int j=mid;
                while(j<arr.length){
                    if(arr[j]==x){
                        max=j;
                    }
                    else{
                        break;
                    }
                    j++;
                }
                break;
            }
            
            else if(arr[mid]>x){
                r=mid-1;
            }
            else {
                l=mid+1;
            }
        }
        list.add(min);
        list.add(max);
        return list;
    }
}
