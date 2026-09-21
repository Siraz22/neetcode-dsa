/*
"The right man, in the wrong place, can make all the difference in the world."
- G-Man, Half Life 2
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;

        Set<Character> set = new HashSet<>();
        int answer = 0;
        
        while(right < s.length()){
            char currChar = s.charAt(right);

            if(set.contains(currChar)){
                while(set.contains(currChar)){
                    set.remove(s.charAt(left));
                    left++;
                }
            }
            else{
                set.add(currChar);
                right++;
                answer = Math.max(answer, right - left);
                //+1 since we want length, not index diff
            }
        }

        return answer;
    }
}