/*
"Always fear the flame, lest you be devoured by it, and lose yourself."
- Quelana of Izalith, Dark Souls
*/

class Solution {
    public int numOfSubarrays(int[] arr) {
        int answer = 0;
        int mod = 1000000007;

        int evenPrefixCount = 0;
        int oddPrefixCount = 0;

        int currSum = 0;
        for(int num : arr){
            currSum += num;
            if(currSum % 2 ==0){
                answer = (answer + oddPrefixCount)%mod;
                evenPrefixCount++;
            }
            else{
                answer +=1%mod;
                answer = (answer + evenPrefixCount)%mod;
                oddPrefixCount++;
            }
        }

        return answer % mod;
    }
}