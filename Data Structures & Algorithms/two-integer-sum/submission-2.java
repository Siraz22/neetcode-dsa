/*
"You're the closest to Heaven that I'll ever be"
- Iris, Goo Goo Dolls
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for(int i =0;i<nums.length;++i){
            int currNum = nums[i];
            //currNum + req = target => req = target - currNum
            if(hashmap.containsKey(target - currNum)){
                int[] answer = new int[]{i, hashmap.get(target-currNum)};
                Arrays.sort(answer);
                return answer;
            }
            hashmap.put(currNum, i);
        }
        return new int[2];
    }
}
