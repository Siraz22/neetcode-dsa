/*
"Science compels us to explode the sun"
- Pye, Nomai scientist, Outer Wilds
*/

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        List<Integer>[] bucket = new List[nums.length+1];

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int numberCount = entry.getValue();
            int number = entry.getKey();
            if(bucket[numberCount] == null){
                bucket[numberCount] = new ArrayList<>();
            }
            bucket[numberCount].add(number);
        }

        int[] answer = new int[k];

        for(int i = bucket.length-1, answerIter = 0; i>=0 && k>0; --i){
            if(bucket[i] != null){
                for(int j=0;j<bucket[i].size();++j){
                    answer[answerIter] = bucket[i].get(j);
                    answerIter++;
                    k--;
                }
            }
        }

        return answer;
    }
}
