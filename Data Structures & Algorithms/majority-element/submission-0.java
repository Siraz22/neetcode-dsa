/*
"जिन्हें देखने से मिले दिल को राहत
बहुत ख़ूबसूरत हो आप सर से पाँव तक"
- Arijit Singh, Dil Jhoom
*/

class Solution {
    public int majorityElement(int[] nums) {
        int count = 1;
        int contender = nums[0];
        for(int i=1;i<nums.length;++i){
            if(contender == nums[i])
                count++;
            else
                count--;

            if(count < 0){
                contender = nums[i];
                count = 1;
            }
        }

        return contender;
    }
}