package DynamicProgramming;

public class BuyAndSellInfiniteTransWithFee 
{
   public static int BuyAndSellInfiniteTransWithFeeDp(int prices[],int transFee)
   {
     int obdp = -prices[0];  //initially we have 0 rupees with us and if we buy a share we will have a loan of current price on 1st day 
     int osdp =  0;  //if we buy of current day we cannot sell on current day 
     for(int i = 1;i<prices.length;i++)
     {
         int nbdp = 0;  //new buying day profit 
         int nsdp = 0;  //new selling day profit
         if(obdp < osdp - prices[i])  // In buying day profit if old buy day rate or loan is < osdp - prices[i] or the loan left to pay after using previous day profit example if -10 < -9 loan of rupee 9 is easier to pay than of rupee 10 example osdp = -10 and loan left after reducing current price with previous day sale profit is -9 so  loan of rupee 9 is less than rupee 10 set the current price
          {
            nbdp = osdp - prices[i];
          }
         else 
         {
            nbdp = obdp; //else if the old buy day loan is less to pay example obdp = -9 and current profit = -10 then loan of rupee 9 is easier to pay then set new buy day profit as old buy day profit 
         }
         if(obdp + prices[i] - transFee > osdp)  //selling day = old buying rate or loan + money to recieve after selling - transaction fee if it is greater than old selling profit then set it as new selling profit day 
         {
            nsdp = obdp + prices[i] - transFee;
         }
         else  //if current selling profit is not greater than old selling day profit then set old selling day profit as new selling day profit 
         {
           nsdp = osdp;
         }
         obdp = nbdp; // make new buying day profit and new selling day profit as old for next transaction 
         osdp = nsdp;
     }
     return osdp; //returning in end the maximum profit recieve after buying on minimum and selling on max
   }
   public static void main(String[] args) {
    int prices[] = {10,15,17,20,16,18,22,20,23,25};
    System.out.println(BuyAndSellInfiniteTransWithFeeDp(prices, 3));

   }
    
}
