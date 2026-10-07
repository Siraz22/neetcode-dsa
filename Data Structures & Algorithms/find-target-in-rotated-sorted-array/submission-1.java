/*
"It's ironic, isn't it? When granted everything, you can't do anything."
- Satoru Gojo, Jujutsu Kaisen
*/

class Solution {

    public int minIndexBSearch(int[] nums){
        int left = 0;
        int right = nums.length-1;

        while(left < right){
            int mid = left + (right - left)/2;

            if(nums[mid] > nums[right]){
                //mid belongs to left sorted part
                left = mid+1;
            }
            else{
                right = mid;
            }
        }
        return left;
    }

    public int search(int[] nums, int target) {

        int pivot = minIndexBSearch(nums);
        int left = -1;
        int right = -1;

        if(pivot == 0){
            left = 0;
            right = nums.length-1;
        }
        else if(nums[0] <= target && target <= nums[pivot-1]){
            left = 0;
            right = pivot-1;
        }
        else{
            left = pivot;
            right = nums.length-1;
        }

        while(left <= right){
            int mid = left + (right-left)/2;

            if(target == nums[mid])
                return mid;

            if(nums[mid] < target){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return -1;
    }
}