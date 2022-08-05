package DynamicProgramming;

public class BuyAndSellStocksInfiniteTransactions {
    public static int BuyAndSellStocksInfiniteTransactionsDp(int prices[])
    {
        int sd = 0; //on the first day both buy day and sell day will be on same day or index the sale day will increase only when there is rise in the price than previous prices if the prices are declining then both the sale and buy day will move forward untill they notice the rice in price we cannot make profit if the prices are constantly declining so we will not buy at low price because we will not able to sell at high price becausr=e of decline in prices so only option is to postpone buying and selling date by incrementing
        int bd = 0;
        int profit = 0;
        for(int i = 1;i<prices.length;i++)
        {
            if(prices[i] >= prices[i-1])  ///if current day price is greater than or equal to the previous day price then there is rise in price going on increment or postpone the sales day until we hit a decline in prices 
            {
                sd++;
            }
            else  //current day price is less than the previous day price then increment both buying price and selling price as we cannot make profit if the price of shares is decreasing example current price is 4 and previous day price was 6 now if we sell now we will have loss of 2            
            {
               profit += prices[sd] - prices[bd]; // before incrementing sales day and buying day retain the current profit which is difference between the price of selling day and the buy day for examle prices are 3,4,5,1 on 1 share face decline condition will come to else it will calculate profit between 5-3 = 2 and then increase both the selling day and buying day until a further rise in price occurs 
               sd = i; //incrementing both untill the prices are decreasing  
               bd = i;   
            }
        }
        profit += prices[sd] - prices[bd]; //when there is rising prices at the end and the loop also comes to end but the last rise in share remains uncounted example 1,2,3,0,4,6 loop will terminate on 6 and buying day will be on 0 and selling on 6 which is remaining to calculate as the loop terminated at price 6 
        return profit;
    }  
    public static void main(String[] args) {
        int prices[] = {1,2,3,0,4,6};
        System.out.println(BuyAndSellStocksInfiniteTransactionsDp(prices));
    }
}
