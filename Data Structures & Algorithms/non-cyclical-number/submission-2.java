/*
"You dare use my own spells against me?"
- Severus Snape, Harry Potter and the Half-Blood Prince
*/

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<Integer>();
        int prod = 0;
        while(n>0){
            int rem = n%10;
            n = n/10;
            prod += (int) Math.pow(rem, 2);
            
            if(n==0){
                if(prod == 1) return true;
                if(set.contains(prod)) return false;
                else set.add(prod);
                n = prod;
                prod = 0;
            }
        }
        return false;
    }
}
