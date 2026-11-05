/*
"And I strongly believe, that there are only successful men in this world.
Unsuccessful, are not men."
- Maheshwari, Kota Factory Season 2
*/

class Solution {
    boolean[] visited;

    private void dfs(ArrayList<ArrayList<Integer>> adj, int node){
        if(visited[node]) return;
        
        visited[node]=true;
        for(int neighbour : adj.get(node)){
            dfs(adj, neighbour);
        }
    }

    public int countComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        visited = new boolean[n];

        for(int i=0;i<n;++i){
            adj.add(new ArrayList<>());
        }

        //[0,1] means 0 <-> 1
        for(int[] pair : edges){
            adj.get(pair[0]).add(pair[1]);
            adj.get(pair[1]).add(pair[0]);
        }

        int count = 0;

        for(int i=0;i<n;++i){
            if(visited[i] == false)
                count++; //not visited before, so new graph
            dfs(adj, i);
        }

        return count;
    }
}