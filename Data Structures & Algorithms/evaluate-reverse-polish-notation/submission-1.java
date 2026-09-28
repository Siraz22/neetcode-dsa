/*
"Despite everything, it is still you"
- Undertale
*/

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for(int i =0;i<tokens.length;++i){
            String str = tokens[i];
            if(Arrays.asList("+","-","/","*").contains(str)){
                Integer second = Integer.parseInt(stack.pop());
                Integer first = Integer.parseInt(stack.pop());
                
                if(str.equals("-")){
                    stack.push(String.valueOf(first - second));
                }
                else if(str.equals("+")){
                    stack.push(String.valueOf(first + second));
                }
                else if(str.equals("/")){
                    stack.push(String.valueOf(first/second));
                }
                else{
                    stack.push(String.valueOf(first*second));
                }
            }
            else{
                stack.push(str);
            }
        }

        return Integer.parseInt(stack.pop());
    }
}