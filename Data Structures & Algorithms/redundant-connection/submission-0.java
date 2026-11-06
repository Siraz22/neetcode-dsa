/*
"In life, unlike chess, the game continues after checkmate."
- Issac Asimov
*/

class Solution {
    class UnionFind{
        int[] parent;
        int[] rank;

        UnionFind(int n){
            parent= new int[n+1];
            rank = new int[n+1];
            for(int i=0;i<=n;++i)
                parent[i] = i;
        }

        public int findParent(int node){
            if(parent[node] == node)
                return node;
            parent[node] = findParent(parent[node]); //path compression
            return parent[node];
        }

        public boolean union(int node1, int node2){
            int parent1 = findParent(node1);
            int parent2 = findParent(node2);
            
            if(parent1 == parent2) return false;
            
            //connect lower rank to higher
            if(rank[parent1] < rank[parent2]){
                parent[parent1] = parent2;
            }
            else if(rank[parent1] > rank[parent2]){
                parent[parent2] = parent1;
            }
            else{ //both rank same
                parent[parent1] = parent2;
                rank[parent2]++;
            }
            return true;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length);

        for(int[] edge : edges){
            int node1 = edge[0];
            int node2 = edge[1];
            boolean didUnion = uf.union(node1, node2);
            if(!didUnion)
                return edge;
        }
        return new int[2];
    }
}