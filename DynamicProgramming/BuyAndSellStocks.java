package DynamicProgramming;

public class BuyAndSellStocks {
    public static int BuyAndSellStocksDp(int prices[])
    {
        int lBuy = Integer.MAX_VALUE;  //initially least buy is max value 
        int op = Integer.MIN_VALUE; //overall profit is minimum 
        for(int i = 0;i<prices.length;i++)  //1,2,3
        {
            if(prices[i] < lBuy)  //if price of stocks to buy on current day is less than our least buy then change the overall least buy 
            {
               lBuy = prices[i];  
            }
            int currProfit = prices[i] - lBuy;  //calculate the maximum profit if we sell stock on the ith index or current day by deducting it with the least buy 
            if(currProfit > op) //if current profit is greater than the overall profit then update overall profit with currprofit           
            {
                op = currProfit;
            }
        }                                                                                                    
        return op;
    }
    public static void main(String[] args) {
        int prices[] = {9,11,6,7,19,4,1,6,18,4};
        System.out.println(BuyAndSellStocksDp(prices));
    }
}
