class Solution {
    public void dfs(int i,boolean visited[],LinkedList<Integer> adj[]){
        for(Integer it:adj[i]){
            if(!visited[it]){
                visited[it]=true;
                dfs(it,visited,adj);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int R=isConnected.length;
        boolean visited[]=new boolean[R];
        int count=0;
        LinkedList<Integer> adj[]=new LinkedList[R];
        for(int row=0;row<R;row++){
            adj[row]=new LinkedList<>();

        }
        for(int row=0;row<R;row++){
            for(int col=0;col<R;col++){
                if(isConnected[row][col]==1){
                     adj[row].add(col);
                }
            }
        }

        for(int row=0;row<R;row++){
           
                if(!visited[row]){
                    visited[row]=true;
                    count++;
                    dfs(row,visited,adj);
                }
            
        }
        return count;
    }
}
