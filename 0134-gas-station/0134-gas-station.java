class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0, currStart = 0, currDifferential = 0;
        for (int i = 0; i < cost.length; i++) {
            totalCost += cost[i];
            totalGas += gas[i];

            currDifferential += (gas[i] - cost[i]);
            // if it drops below 0, we know we cannot start at that point.
            // so must update the currStart
            if (currDifferential < 0) {
                currStart = i + 1;
                currDifferential = 0;
            }
        }
        return totalCost <= totalGas ? currStart : -1;
    }
}