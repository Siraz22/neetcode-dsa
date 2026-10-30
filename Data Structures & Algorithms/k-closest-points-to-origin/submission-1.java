/*
"हम बदले नहीं
हम डरते नहीं
सब वहीं का वहीं"
- Wahi ka Wahi, Lifafa
*/

class Solution {
    class Pair{
        int x;
        int y;
        double distance;

        Pair(int x, int y){
            this.x = x;
            this.y = y;
            this.distance = Math.sqrt(x*x + y*y);
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        Queue<Pair> pq = new PriorityQueue<Pair>((p1,p2) -> p2.distance > p1.distance ? 1:-1);

        for(int[] coordinate : points){
            pq.offer(new Pair(coordinate[0], coordinate[1]));
            if(pq.size() > k){
                pq.poll();
            }
        }

        int[][] answer = new int[k][2];
        while(pq.size() > 0){
            int indexToFill = k - pq.size();
            Pair p = pq.poll();
            answer[indexToFill][0] = p.x;
            answer[indexToFill][1] = p.y;
        }

        return answer;
    }
}