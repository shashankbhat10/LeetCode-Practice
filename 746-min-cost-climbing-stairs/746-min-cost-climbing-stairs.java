class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] costs = new int[cost.length];
        
        if(cost.length == 0)
            return 0;
        
        if(cost.length == 1 || cost.length == 2)
            return Math.min(cost[0], cost[1]);
        
        for(int i=0; i<cost.length; i++){
            if(i == 0 || i == 1)
                costs[i] = cost[i];
            else
                costs[i] = cost[i] + Math.min(costs[i-1], costs[i-2]);
        }
        
        int len = cost.length;
        return Math.min(costs[len-1], costs[len-2]);
    }
}