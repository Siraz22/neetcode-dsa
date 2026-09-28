/*
"It is a lovely thing that we have"
- Animal Instinct, The Cranberries
*/

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int[] answer = new int[nums.length-k+1];
        Deque<Integer> dq = new ArrayDeque<>();
        
        for(int i =0;i<nums.length;++i){
            int num = nums[i];
            if(dq.size() == 0)
                dq.addLast(i);
            else if(dq.size() > 0 && nums[dq.peekLast()] >= num)
                dq.addLast(i);
            else if(dq.size() > 0 && nums[dq.peekLast()] < num){
                while(dq.size() > 0 && nums[dq.peekLast()] < num){
                    dq.removeLast();
                }
                dq.addLast(i);
            }
            
            if(i >= k){
                int removeIdx = i-k;
                if(dq.peekFirst() == removeIdx){
                    dq.removeFirst();
                }
            }

            if(i>=k-1){
                answer[i-(k-1)] = nums[dq.peekFirst()];
            }
        }

        return answer;
    }
}
