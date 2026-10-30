/*
"Don’t make a girl a promise if you know you can’t keep it."
- Cortana, Halo 3
*/

class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<Integer>();

        for(int num : nums){
            pq.offer(num);
            if(pq.size() > k)
                pq.poll();
        }

        return pq.peek();
    }
}