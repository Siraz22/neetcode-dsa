/*
"Here comes the train upon the track
And there goes the pain it cuts to black"
- A step you can't take back, Begin Again
*/

class Solution {
    private int[] expand(String word, int leftIter, int rightIter) {
        int left = -1;
        int right = -1;

        while (leftIter >= 0 && rightIter < word.length()) {

            if (word.charAt(leftIter) == word.charAt(rightIter)) {
                left = leftIter;
                right = rightIter;

                leftIter--;
                rightIter++;
            } else {
                break;
            }
        }
        return new int[]{left, right};
    }

    public String longestPalindrome(String s) {
        int left = 0;
        int right = 0;

        for (int i = 0; i < s.length(); ++i) {

            int[] odd = expand(s, i, i);
            int[] even = expand(s, i, i + 1);

            if (odd[0] != -1 && odd[1] - odd[0] > right - left) {
                left = odd[0];
                right = odd[1];
            }

            if (even[0] != -1 && even[1] - even[0] > right - left) {
                left = even[0];
                right = even[1];
            }
        }
        return s.substring(left, right + 1);
    }
}
