class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        int n = nums.length;
        int m = multipliers.length;
        return helper(nums, multipliers, 0, 0, n-1, new int[m][m]);
    }
    
    private int helper(int[] nums, int[] multipliers, int index, int left, int right, int[][] memo){
        if(index == multipliers.length) return 0;
        if(memo[left][index] != 0) return memo[left][index];
        
        int considerLeft = nums[left] * multipliers[index] + helper(nums, multipliers, index+1, left+1, right, memo);
        
        int considerRight = nums[right] * multipliers[index] + helper(nums, multipliers, index+1, left, right - 1, memo);
        
        memo[left][index] = Math.max(considerLeft, considerRight);
        return memo[left][index];
    }
}