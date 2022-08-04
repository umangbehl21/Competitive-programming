package DynamicProgramming;

public class BuyAndSellStocksTwoTransactions
{   
    public static int BuyAndSellStocksTwoTransactions(int prices[])  //sell from left to right buy from right to left eithout overlapping 
    {
       int lBuy = prices[0];
       int dp_LtoR[] = new int[prices.length]; //ongoing left to right we calculate the max profit if selling is mandatory today and compare it to the max profit which we can obtain from selling till now (means from the previous days)
       dp_LtoR[0] = 0;  //selling point till now as it is the first selling point there is no day before it so we have bought today at same price and sold today at same price 
       for(int i = 1;i<prices.length;i++)
       {
           if(prices[i] < lBuy)  //if current buy price is less than the least price then update least buy to current price 
           {
              lBuy = prices[i]; 
           }
           int curr_MaxProfit_St = prices[i] - lBuy; //Current max profit of today if selling today is mandatory 
           if(curr_MaxProfit_St > dp_LtoR[i-1])  //if current Maxprofit of selling today is greater than Max Profit which can be obtained from selling till now then set MaxProfit of selling today on current index 
           {
              dp_LtoR[i] = curr_MaxProfit_St; 
           } 
           else 
           {
             dp_LtoR[i] = dp_LtoR[i-1]; //else store the max selling profit till now of the previous day 
           }
       } 
       int MaxProfit_IfBuy_AfterToday = prices[prices.length-1]; //initially when there are no buying days after today then it will we out MaxProfitAfter today 
       int dp_RtoL[] = new int[prices.length];  //from right to left we calculate maximum profit if bought today or the max profit if bought after today  
       dp_RtoL[dp_RtoL.length-1] = 0; //maximum profit if buy today and there are not buying after that then we have to sell on that day profit will be 0 
       for(int i = prices.length-2;i>=0;i--)
       {
         if(prices[i] > MaxProfit_IfBuy_AfterToday)  //updating max profit if buy after today at every point because it can be the selling point example for 3,2,7,6 loop start from 6 then when it comes to 7 now 7 price or curr price is greater than 6 so we will update 7 as the max profit after today and when loop comes to 2 it will calculate its profit from 7-2 so if we don;t update max profit after today was fixed at 6
         {
            MaxProfit_IfBuy_AfterToday = prices[i];
         }
         int MaxprofitIfBuyToday = MaxProfit_IfBuy_AfterToday - prices[i]; //highest future prize - current price
         if(MaxprofitIfBuyToday > dp_RtoL[i+1])//for prices {3,2,3} Length = 3 start from index 1 and comparison from index after it i.e 2
         {                                     //if MaxprofitIfBuyToday is more than Maxprofit_after_today then set at current index the profit of current buy day   
            dp_RtoL[i] = MaxprofitIfBuyToday;  
         }
         else  //else if MaxProfit of today is less than the max profit after today then set the profit of after today in the current index because it is better 
         {
           dp_RtoL[i] = dp_RtoL[i+1];
         }
       }
       int op = 0; //overall profit 
       for(int i = 0;i<dp_LtoR.length;i++)
       {
           if(dp_LtoR[i] + dp_RtoL[i] > op)  //sum of the two dp which stores the best selling day till now and the maximum profit buying today or afterwards
           {
              op = dp_LtoR[i] + dp_RtoL[i];
           }
       }
       return op;

    }
    public static void main(String[] args) {
        int prices[] = {10,20,30};
        System.out.println(BuyAndSellStocksTwoTransactions(prices));
    } 

}
