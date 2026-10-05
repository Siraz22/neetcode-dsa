/*
"my brother, Itadori Yuji,
In the name of Aoi Todo...
We recommend them to be promoted to Grade 1 Sorcerers"
- Aoi Todo & Mei Mei, Jujutse Kaisen
*/

class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;

        while(left < right){
            int mid = left + (right-left)/2;

            if(nums[mid] > nums[right]){
                //left is sorted
                left = mid+1;
            }
            else{
                right = mid;
            }
        }
        return nums[left];
    }
}