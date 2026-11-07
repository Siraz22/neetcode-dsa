/*
"Chahe jitni shamaye roshan karlo,
Dhoop toh dhal jayegi jayegi"
- Amit Trivedi, Ha Reham (Aamir, 2008)
*/

class Solution {
    class Node {
        int val;
        int weight;

        public Node(int val, int weight){
            this.val = val;
            this.weight = weight;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        Queue<Node> pq = new PriorityQueue<Node>((Node n1, Node n2) -> n1.weight - n2.weight);
        
        ArrayList<ArrayList<Node>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());
        
        int[] distance = new int[n+1];
        for(int i=0;i<distance.length;++i)
            distance[i] = Integer.MAX_VALUE;
        
        for(int[] node : times){
            //node is [2(source), 1(dest), 1(weight)]
            adj.get(node[0]).add(new Node(node[1], node[2]));
        }

        pq.offer(new Node(k, 0));
        distance[k] = 0;

        while(!pq.isEmpty()){
            Node node = pq.poll();

            if(node.weight > distance[node.val])
                continue;

            for(Node neighbour : adj.get(node.val)){
                int newWeight = node.weight + neighbour.weight;

                //is going from current node to this neighbour better?
                if(newWeight < distance[neighbour.val]){ 
                    distance[neighbour.val] = newWeight;
                    pq.offer(new Node(neighbour.val, newWeight));
                }
            }
        }

        int maxWeight = 0;
        //index starts from 1
        for(int i=1;i<distance.length;++i){
            if(distance[i] == Integer.MAX_VALUE) 
                return -1;
            maxWeight = Math.max(distance[i], maxWeight);
        }

        return maxWeight;
    }
}