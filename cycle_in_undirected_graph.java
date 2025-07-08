class Solution {
    public boolean detectCycle(int node,int [][]edges,boolean visited[],List<Integer> adj[]){
        Queue<Integer[]> q=new LinkedList<>();
        q.offer(new Integer[]{node,-1});
        visited[node]=true;
        while(!q.isEmpty()){
            Integer arr[]=new Integer[2];
            arr=q.poll();
            int n=arr[0];
            int pn=arr[1];
            for(int it:adj[n]){
                if(!visited[it]){
                    visited[it]=true;
                    q.offer(new Integer[]{it,n});
                }
                else{
                    if(pn!=it){
                        return true;
                    }
                }
}
            
        }
        return false;
    }
    public boolean isCycle(int V, int[][] edges) {
        // Code here
    List<Integer> adj[]=new ArrayList[V];
    for(int i=0;i<V;i++){
        adj[i]=new ArrayList<>();
    }
    
    for(int i=0;i<edges.length;i++){
        int r=i;
        adj[edges[i][0]].add(edges[i][1]);
        adj[edges[i][1]].add(edges[i][0]);
    }
    
     boolean visited[]=new boolean[V];
    for( int i=0;i<V;i++){
        if(!visited[i]){
           if( detectCycle(i,edges,visited,adj))return true;
        }
    }
    
        return false;
    }
}
