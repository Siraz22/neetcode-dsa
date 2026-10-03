/*
"सारे पूछे मन्ने कित से,
रहता भाइयाँ के दिला में।"
- Kitse, Mohito
*/

class Solution {

    private ArrayList<Integer> nextSmallerEle(int[] arr) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        for(int i=0;i<arr.length;++i){
            answer.add(-1);
        }

        Stack<Integer> stack = new Stack<Integer>();
        for(int i = arr.length-1; i>=0; --i){
            if(stack.isEmpty()){
                stack.push(i);
                answer.set(i,-1);
            }
            else{
                if(arr[stack.peek()] < arr[i]){
                    answer.set(i, stack.peek());
                    stack.push(i);
                }
                else{
                    while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                        stack.pop();
                    }

                    answer.set(i, stack.isEmpty() ? -1 : stack.peek());
                    stack.push(i);
                }
            }
        }

        return answer;
    }

    private ArrayList<Integer> prevSmaller(int[] arr) {
        // code here
        ArrayList<Integer> answer = new ArrayList<Integer>();
        for(int i=0;i<arr.length;++i){
            answer.add(-1);
        }

        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < arr.length; ++i){
            if(stack.isEmpty()){
                stack.push(i);
                answer.set(i,-1);
            }
            else{
                if(arr[stack.peek()] < arr[i]){
                    answer.set(i, stack.peek());
                    stack.push(i);
                }
                else{
                    while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                        stack.pop();
                    }

                    answer.set(i, stack.isEmpty() ? -1 : stack.peek());
                    stack.push(i);
                }
            }
        }

        return answer;
    }

    public int largestRectangleArea(int[] heights) {
        ArrayList<Integer> prevSmallerIdxs = prevSmaller(heights);
        ArrayList<Integer> nextSmallerIdxs = nextSmallerEle(heights);

        int answer = 0;
        for (int i = 0; i < heights.length; ++i) {
            int prev = prevSmallerIdxs.get(i);
            int next = nextSmallerIdxs.get(i);

            int leftBoundary = prev == -1 ? -1 : prev;
            int rightBoundary = next == -1 ? heights.length : next;

            int width = rightBoundary - leftBoundary - 1;
            int area = heights[i] * width;

            answer = Math.max(answer, area);
        }

        return answer;
    }
}