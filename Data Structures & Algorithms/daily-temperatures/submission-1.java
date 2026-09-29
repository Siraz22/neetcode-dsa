/*
"A famous explorer once said that the extraordinary is in what we do, not who we are."
- Lara Croft, Tomb Raider
*/

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];

        Stack<Integer> indexStack = new Stack<>();

        for(int i=0;i<temperatures.length;++i){
            int currTemp = temperatures[i];
            if(indexStack.isEmpty() || (!indexStack.isEmpty() && temperatures[indexStack.peek()] >= currTemp)){
                indexStack.push(i);
            }
            else{
                while(!indexStack.isEmpty() && temperatures[indexStack.peek()] < currTemp){
                    int poppedIndex = indexStack.pop();
                    answer[poppedIndex] = i-poppedIndex;
                }
                indexStack.push(i);
            }
        }

        return answer;
    }
}
