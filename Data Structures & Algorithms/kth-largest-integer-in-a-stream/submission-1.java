/*
"Magic is just science that we don't understand yet."
- Arthur C. Clarke
*/

class KthLargest {

    Queue<Integer> pq;
    int size;

    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<Integer>(k);
        for(int num : nums){
            pq.add(num);
        }
        this.size = k;
    }
    
    public int add(int val) {
        pq.offer(val);
        while(pq.size() > size){
            pq.poll();
        }
        return pq.peek();
    }
}