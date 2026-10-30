/*
"I only wanted to see you
Laughing in the purple rain"
- Purple Rain, Price
*/

class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> pq = new PriorityQueue<Integer>((a,b) -> b - a); //maxHeap
        for(int stoneWeight : stones){
            pq.add(stoneWeight);
        }

        while(pq.size()>=2){
            int heavier = pq.poll();
            int heavy = pq.poll();
            if(heavier == heavy)
                continue;
            else
                pq.offer(heavier - heavy);
        }    

        return pq.size() == 0 ? 0 : pq.peek();
    }
}