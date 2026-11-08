/*
"सजरा सवेरा मेरे तन बरसे
कजरा अँधेरा तेरी जलती लौ"
- A. R. Rahman, Kun Faya Kun (Rockstar)
*/

class Solution {
    public int removeElement(int[] nums, int val) {
        int left = 0;
        for(int i=0;i<nums.length;++i){
            if(nums[i]!=val){
                nums[left] = nums[i];
                left++;
            }
        }
        return left;
    }
}