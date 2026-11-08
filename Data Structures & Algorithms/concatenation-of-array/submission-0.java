/*
"Everybody wants to save the world, they just… they disagree on how." 
– Maximus, Fallout Series
*/

class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] answer = new int[nums.length*2];
        for(int mul=0;mul<=1;++mul){
            for(int i=0;i<nums.length;++i){
                answer[mul*nums.length + i] = nums[i];
            }
        }
        return answer;
    }
}