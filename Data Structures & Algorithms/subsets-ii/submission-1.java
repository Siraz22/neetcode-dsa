/*
"When we make little sacrifices we like to have them appreciated, at least."
- Louisa May, Little Women
*/

class Solution {

    List<List<Integer>> answer;

    public void recursion(int[] nums, int pos, List<Integer> subset){
        if(pos >= nums.length){
            // if(!answer.contains(subset))
            answer.add(subset);
            return;
        }

        //choice 1 : choose current
        List<Integer> chosen = new ArrayList<Integer>(subset);
        chosen.add(nums[pos]);
        recursion(nums, pos+1, chosen);

        //choice 2 : do not choose current
        int nextPos = pos+1;
        while(nextPos < nums.length && nums[nextPos] == nums[pos]) {
            nextPos++;
        }

        List<Integer> notChosen = new ArrayList<Integer>(subset);
        recursion(nums, nextPos, notChosen);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        answer = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        recursion(nums,0, new ArrayList<Integer>());
        return answer;
    }
}