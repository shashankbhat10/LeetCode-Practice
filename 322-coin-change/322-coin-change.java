class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int target = 1; target < dp.length; target++) {
            dp[target] = dp.length;
            for (int coin : coins) {
                if (target >= coin) {
                    dp[target] = Math.min(dp[target], dp[target - coin] + 1);
                }
            }
        }
        return dp[amount] == dp.length ? -1 : dp[amount];
    }
}