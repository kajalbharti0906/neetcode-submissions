class Solution {
    public int maxProfit(int[] prices) {
        // 10,1,5,6,7,1
        int minprice = prices[0];
        int res = 0;
        for(int i=1;i<prices.length;i++) {
            if(prices[i]<minprice) {
                minprice = prices[i];
            } else {
                res = Math.max(res, prices[i]-minprice);
            }
        }
        return res;
    }
}
