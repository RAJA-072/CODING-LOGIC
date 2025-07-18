

class Solution {
    int dir[][]=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    void dfs(int row,int col,int grid[][],boolean vis[][]){
        for(int i=0;i<4;i++){
            int adjX=row+dir[i][0];
            int adjY=col+dir[i][1];
            if(adjX>=0 && adjX<grid.length && adjY>=0 && adjY<grid[0].length && !vis[adjX][adjY] && grid[adjX][adjY]==1){
                vis[adjX][adjY]=true;
                grid[adjX][adjY]=0;
                dfs(adjX,adjY,grid,vis);
            }
        }
    }
    int numberOfEnclaves(int[][] grid) {

        // Your code here
        int R=grid.length;
        int C=grid[0].length;
        
        boolean vis[][]=new boolean [R][C];
        for(int i=0;i<C;i++){
            if(grid[0][i]==1){
                vis[0][i]=true;
                dfs(0,i,grid,vis);
            }
            
            if(grid[R-1][i]==1){
                vis[R-1][i]=true;
                dfs(R-1,i,grid,vis);
            }
        }
        
        for(int i=0;i<R;i++){
            if(grid[i][0]==1){
                vis[i][0]=true;
                dfs(i,0,grid,vis);
            }
            
            if(grid[i][C-1]==1){
                vis[i][0]=true;
                dfs(i,C-1,grid,vis);
            }
        }
        int count=0;
        for(int i=1;i<R-1;i++){
            for(int j=1;j<C-1;j++){
                if(!vis[i][j] && grid[i][j]==1){
                    count++;
                }
            }
        }
        return count;
    }
}
