/*
"Culture should not be restricted only to people who can afford it"
- Arsi "Hakita" Patala, Overkill
*/

public class Solution{
    ArrayList<Integer> topoSort(ArrayList<ArrayList<Integer>> adj){
        int[] indegree = new int[adj.size()];
        for(int i=0;i<adj.size();++i){
            ArrayList<Integer> list = adj.get(i);
            for(int num : list){
                indegree[num]++;
            }
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i=0;i<indegree.length;++i){
            if(indegree[i] == 0)
                queue.add(i);
        }

        ArrayList<Integer> answer = new ArrayList<Integer>();
        while(!queue.isEmpty()){
            int elem = queue.poll();

            //decrease indegree where ever this elem is present
            for(int destination : adj.get(elem)){
                indegree[destination]--;
                if(indegree[destination] == 0){
                    queue.offer(destination);
                }
            }
            answer.add(elem);
        }
        return answer;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<numCourses;++i){
            adj.add(new ArrayList<>());
        }

        //[1,0] => 1 needs 0, so 0 has indegree of 0, 1 has of 1, thus graph is 1 <- 0
        for(int[] pair : prerequisites){
            int start = pair[1];
            int edgeTo = pair[0];
            adj.get(start).add(edgeTo);
        }

        return numCourses == topoSort(adj).size();
    }   
}