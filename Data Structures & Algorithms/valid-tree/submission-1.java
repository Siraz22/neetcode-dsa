/*
"All animals are equal, but some animals are more equal than others."
- Animal Farm, George Orwell
*/

class Solution {
    boolean[] visited;

    private boolean dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj){        
        visited[node] = true;
        for(int neighbour : adj.get(node)){
            if(visited[neighbour]){
                if(parent!=neighbour){
                    //we are coming back to visited node, which is not our parent
                    return false;
                }
            }
            else{
                boolean dfsResult = dfs(neighbour, node, adj);
                if(dfsResult == false) return false;
            }
        }
        return true;
    }

    public boolean validTree(int n, int[][] edges) {
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

        if(dfs(0, -1, adj) == false)
            return false;

        for(int i=0;i<n;++i){
            if(visited[i] == false)
                return false;
        }
        return true;
    }
}
