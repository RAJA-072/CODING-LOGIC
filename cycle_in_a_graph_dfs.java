class Solution {
    public boolean dfs(int node,int parent,LinkedList<Integer> adj[],boolean visited[]){
        for(int it:adj[node]){
            if(!visited[it]){
                visited[it]=true;
                if(dfs(it,node,adj,visited))return true;
            }
            else{
                if(it!=parent){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isCycle(int V, int[][] edges) {
        
        LinkedList<Integer> adj[]=new LinkedList[V];
        int R=edges.length;
        for(int i=0;i<V;i++){
            adj[i]=new LinkedList<>();
        }
        for(int i=0;i<R;i++){
            adj[edges[i][0]].add(edges[i][1]);
            adj[edges[i][1]].add(edges[i][0]);
        }
        boolean visited[]=new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                visited[i]=true;
                if(dfs(i,-1,adj,visited))return true;
            }
            
        }
        return false;
        
    }
}
