/*
"but... do not question my zeal again, Ultramarine"
- Sa'kan to Brutus, Warhammer 40k
*/

class Solution {

    List<List<Integer>> answer;

    public void recursion(List<Integer> input, List<Integer> output){
        if(input.size() == 0){
            answer.add(new ArrayList<Integer>(output));
            return;
        }

        for(int i=0;i<input.size();++i){
            int chosen = input.get(i);
            ArrayList<Integer> outputCopy = new ArrayList<Integer>(output);
            outputCopy.add(chosen);
            input.remove(i);
            recursion(input, outputCopy);

            //backtrack reset
            input.add(i, chosen);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        answer = new ArrayList<List<Integer>>();
        ArrayList<Integer> input = new ArrayList<Integer>();
        for(int num : nums)
            input.add(num);
        recursion(input, new ArrayList<Integer>());
        return answer;
    }
}