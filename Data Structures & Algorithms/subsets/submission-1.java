/*
"I don't want you to be sad that I'm gone. 
I want you to be amazed that any of us ever had a chance to be here at all."
- Edith, What remains of Edith Finch
*/

class Solution {

    List<List<Integer>> answer;

    public void recursion(int[] nums, int pos, List<Integer> subset){
        if(pos >= nums.length){
            answer.add(subset);
            return;
        }

        //choice 1 : choose current
        List<Integer> chosen = new ArrayList<Integer>(subset);
        chosen.add(nums[pos]);
        recursion(nums, pos+1, chosen);

        //choice 2 : do not choose current
        List<Integer> notChosen = new ArrayList<Integer>(subset);
        recursion(nums, pos+1, notChosen);
    }

    public List<List<Integer>> subsets(int[] nums) {
        answer = new ArrayList<List<Integer>>();
        recursion(nums,0, new ArrayList<Integer>());
        return answer;
    }
}
