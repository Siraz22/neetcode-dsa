/*
"Stand in the ashes of a trillion dead souls and ask the ghosts if honor matters. 
Their silence is your answer." 
-Javik, Mass Effect 3
*/

class Solution {
    List<List<Integer>> answer;

    private void recursion(int[] nums, ArrayList<Integer> input, int pos, int sumLeft){
        if(sumLeft == 0){
            answer.add(input);
            return;
        }
        if(sumLeft < 0)
            return;
        if(pos >= nums.length)
            return;

        //choice 1 : choose current number
        ArrayList<Integer> list = new ArrayList<Integer>(input);
        list.add(nums[pos]);
        recursion(nums, list, pos, sumLeft - nums[pos]);

        //choice 2 : skip current number
        recursion(nums, new ArrayList<Integer>(input), pos+1, sumLeft);
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        answer = new ArrayList<List<Integer>>();
        recursion(nums, new ArrayList<Integer>(), 0, target);
        return answer;
    }
}
