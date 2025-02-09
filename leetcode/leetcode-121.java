class Solution {
    public int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxp =0;
        for(int price: prices){
            if(price<minprice){
                minprice =price;
            } else if((price-minprice)>maxp){
              maxp =price - minprice;
            }
        }
        return maxp;
    }
}