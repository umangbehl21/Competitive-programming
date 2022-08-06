package DynamicProgramming;
public class BuyAndSellStocksInfiniteTransCoolDown
{ 
    public static int BuyAndSellStocksInfiniteTransCoolDownDp(int prices[])  //because we buy on first day we cannot sell on the same day it makes number of buys more than the number of selling which create loan in buying 
    {
        int obdp = -prices[0]; //initially old buying day profit will be negative of first day price 
        int osdp = 0;  //old selling day profit will be 0 as we cannot buy and sell at the same day 
        int ocdp = 0;  //old cooldown profit is 0 because there is no selling on its previous day since it is the first day 
        for(int i = 1;i<prices.length;i++)
        {
            int nbdp = 0;
            int nsdp = 0;
            int ncdp = 0;
            if(obdp < ocdp - prices[i])  //new buy day profit if (old buying day rate or profit) is < (current buying day rate - cooldown profit) example obdp = -10 and nbdp = (current buying rate - money or profit in hand(ocdp)) = 7-16 = -9) so -10 is less than -9 and in the real world the loan of -10 is greater than -9 kust like 10 rupee loan is greater than 9 rupee so we will set -9 less loan to repay in           
            {
               nbdp = ocdp - prices[i];
            }
            else  //else if the current buy rate - old cooldown profit makes loan greater than the old buying rate than keep old buying rate as new buying rate  
            {
              nbdp = obdp;
            }
            if(obdp + prices[i] > osdp) //new selling day profit example old selling day profit is 7 and old (buying rate or loan is -10 and current selling rate is 20) then nsdp = 10 which is greater than old selling profit which was 7 so formula becomes => old buying loan or rate + current selling price is > old selling price
            {
              nsdp = obdp + prices[i];
            }
            else  //else if old selling profit is greater than the new sell day profit then new seeling day profit will be assigned with old profit 
            {
             nsdp = osdp;
            }
            if(ocdp > osdp) //new cooldown profit is greater between the old sell day profit and the old cooldown profit
            {
               ncdp = ocdp;
            }
            else 
            {
                ncdp = osdp;
            }
            obdp = nbdp;  //making new buy day profit new sell day and new cool day profit as old for next iteration
            osdp = nsdp;
            ocdp = ncdp;
        }
        return osdp; //returning in end the maximum profit recieve after buying on minimum and selling on max 
    }
    public static void main(String[] args) {
        int prices[] = {10,15,17,20,16,18,22,20,22,20}; 
        System.out.println(BuyAndSellStocksInfiniteTransCoolDownDp(prices));
    }
} 