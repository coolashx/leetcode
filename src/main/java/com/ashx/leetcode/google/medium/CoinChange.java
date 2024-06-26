package com.ashx.leetcode.google.medium;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/coin-change/">Leetcode</a>
 */
public class CoinChange {
    public static void main(String[] args) {
        CoinChange c = new CoinChange();
        System.out.println(c.coinChange(new int[]{1, 2, 5}, 11)); // 3
        System.out.println(c.coinChange(new int[]{2}, 3)); // -1
        System.out.println(c.coinChange(new int[]{1}, 0)); // 0
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        int ans = coinCount(coins, amount, dp);
        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }

    int coinCount(int[] coins, int amount, int[] dp) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return Integer.MAX_VALUE;
        }
        if (dp[amount] != -1) {
            return dp[amount];
        }

        int minCoins = Integer.MAX_VALUE;
        for (int coin : coins) {
            int ans = coinCount(coins, amount - coin, dp);

            if (ans != Integer.MAX_VALUE) {
                // we have returned 0 in ans, so now we are updating the ans count
                // hence 1 + ans
                minCoins = Math.min(minCoins, 1 + ans);
            }
        }
        return dp[amount] = minCoins;
    }
}
