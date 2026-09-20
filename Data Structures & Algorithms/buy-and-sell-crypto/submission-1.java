/*
"I stopped taking the drugs and now the drugs take me"
- Wishing Well, Juice WRLD
*/

class Solution {
    public int maxProfit(int[] prices) {
        int[] r2l = new int[prices.length];

        r2l[prices.length-1] = prices[prices.length-1];

        for(int i=prices.length-2; i>=0; --i){
            r2l[i] = Math.max(r2l[i+1], prices[i]);
        }

        int profitMax = 0;
        for(int i=0;i<prices.length;++i){
            profitMax = Math.max(profitMax, r2l[i]-prices[i]);
        }

        return profitMax;
    }
}
