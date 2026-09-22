/*
"I know nothing
There is still so much I don’t understand but I really want to learn more so I can love you more"
- Raya P
*/

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            int[] temp = nums1;
            nums1 = nums2; //make nums1 the smaller array
            nums2 = temp;
        }

        int l = nums1.length, m = nums2.length, req_half = (l+m)/2;

        //partition smaller array for Binary Search
        int left = 0, right = l;
        while(left <= right){
            int partitionLengthA = (left + right)/2;
            int partitionLengthB = req_half - partitionLengthA;

            int Aleft = partitionLengthA == 0 ? Integer.MIN_VALUE : nums1[partitionLengthA-1];
            int Aright = partitionLengthA == l ? Integer.MAX_VALUE : nums1[partitionLengthA];
            int Bleft = partitionLengthB == 0 ? Integer.MIN_VALUE : nums2[partitionLengthB-1];
            int Bright = partitionLengthB == m ? Integer.MAX_VALUE : nums2[partitionLengthB];

            if(Aleft <= Bright && Bleft <= Aright){ //found the partition!
                if((l+m)%2 != 0)
                    return Math.min(Aright, Bright);
                else
                    return (Math.max(Aleft, Bleft) + Math.min(Aright, Bright))/2.0;        
            }
            if(Aleft <= Bright) //let's increase Aleft more and see
                left = partitionLengthA + 1;
            else
                right = partitionLengthA - 1;
        }

        return 0.0;
    }
}