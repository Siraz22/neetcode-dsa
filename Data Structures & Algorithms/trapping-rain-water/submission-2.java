/*
"If you gave me a chance, I would take it
It's a shot in the dark, but I'll make it"
- Rather Be, Clean Bandit
*/

class Solution {
    public int trap(int[] height) {
        int[] l2r = new int[height.length];
        int[] r2l = new int[height.length];
    
        l2r[0] = height[0];
        for(int i=1;i<height.length;++i){
            l2r[i] = Math.max(height[i], l2r[i-1]);
        }

        r2l[height.length-1] = height[height.length-1];
        for(int i=height.length-2;i>=0;--i){
            r2l[i] = Math.max(height[i], r2l[i+1]);
        }

        int answer = 0;
        for(int i=1;i<height.length-1;++i){
            answer += Math.abs(height[i] - Math.min(r2l[i], l2r[i]));
        }
        return answer;
    }
}
