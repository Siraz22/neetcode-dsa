/*
"I used to be an adventurer like you, then I took an arrow in the knee."
- Whiterun Guard, Elder Scrolls V : Skyrim
*/

class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] indegree = new int[n+1];
        int[] outdegree = new int[n+1];

        for(int[] edge : trust){
            indegree[edge[1]]++;
            outdegree[edge[0]]++;
        }

        for(int i=1;i<indegree.length;++i){
            if(indegree[i] == n-1 && outdegree[i] == 0) return i;
        }
        return -1;
    }
}