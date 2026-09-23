/*
"The more things change, the more they stay the same."
- Ada Wong, Resident Evil
*/

class Solution {

    private int mostFreqCount(HashMap<Character, Integer> map){
        int maxCount = 0;
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            char ch = entry.getKey();
            int count = entry.getValue();
            maxCount = Math.max(count, maxCount);
        }
        return maxCount;
    }

    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> charMap = new HashMap<>();

        int left = 0;
        int right = 0;
        int maxLen = 0;

        for(; right < s.length(); ++right){
            char currChar = s.charAt(right);
            charMap.put(currChar, charMap.getOrDefault(currChar, 0)+1);

            int mostFreqCharCount = mostFreqCount(charMap);
            int windowLength = right - left + 1;

            while(windowLength - mostFreqCharCount > k){
                //shrink the window
                int toRemoveCharCount = charMap.get(s.charAt(left));
                if(toRemoveCharCount == 1)
                    charMap.remove(s.charAt(left));
                else{
                    charMap.put(s.charAt(left), toRemoveCharCount - 1);
                }

                left++;

                mostFreqCharCount = mostFreqCount(charMap);
                windowLength = right - left + 1;
            }

            maxLen = Math.max(maxLen, windowLength);
        }

        return maxLen;
    }
}