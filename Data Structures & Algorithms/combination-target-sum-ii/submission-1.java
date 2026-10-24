/*
"Saladin, where are you going with that great army?"
- An Arabian Knight, Age of Empires II
*/

class Solution {

    List<List<Integer>> answer;

    private void recursion(int[] nums, ArrayList<Integer> input, int pos, int sumLeft){
        if(sumLeft == 0){    
            answer.add(input);
            return;
        }
        if(sumLeft < 0) return;
        if(pos >= nums.length) return;

        //choice 1 : choose current, go to next
        ArrayList<Integer> list = new ArrayList<Integer>(input);
        list.add(nums[pos]);
        recursion(nums, list, pos+1, sumLeft-nums[pos]);

        //choice 2 : skip current, go to next

        //we skip duplicates on skip level, because a similar previous element would've already given a valid answer if it existed
        int nextPos = pos+1;
        while(nextPos < nums.length && nums[nextPos] == nums[pos]) {
            nextPos++;
        }

        recursion(nums, new ArrayList<Integer>(input), nextPos, sumLeft);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        answer = new ArrayList<List<Integer>>();
        recursion(candidates, new ArrayList<Integer>(), 0, target);
        return answer;
    }
}