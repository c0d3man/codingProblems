import java.util.Arrays;

/**
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

 Example 1:
 coins = [1, 2, 5], amount = 11
 return 3 (11 = 5 + 5 + 1)

 */
public class CoinChange {

        public static int coinChange(int[] coins, int amount) {
            if(amount == 0)
                return 0;
            if(coins == null)
                return -1;
            long mincoin[] = new long[amount];
            Arrays.fill(mincoin,Integer.MAX_VALUE);
            mincoin[0]=0;
            for(int i=1;i<mincoin.length;i++){
                for(int j=0;j<coins.length;j++){
                    if(coins[j]<=i && (mincoin[i-coins[j]]+1 < mincoin[i]))
                        mincoin[i]=mincoin[i-coins[j]]+1;
                }
            }
            long leastCoins = Integer.MAX_VALUE;
            boolean resultFound = false;
            for(int j=0;j<coins.length;j++){
                if(coins[j]<=amount && (mincoin[amount-coins[j]]+1 <= leastCoins)){
                    leastCoins=mincoin[amount-coins[j]]+1;
                    resultFound = true;
                }

            }
            if(resultFound)
                return (int)leastCoins;
            else
                return  -1;


    }
    

}
