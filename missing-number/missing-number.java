class Solution {
    public int missingNumber(int[] nums) {
        // int totalSum = nums.length * (nums.length - 1) / 2;
        // int sum = 0;
        // for(int i=0; i<nums.length; i++){
        //     sum += nums[i];
        // }
        // int len = nums.length;
        // return (len * (len + 1) - (2 * sum)) / 2;
        int length = nums.length;
        int totalSum = length * (length + 1) / 2;
        int arraySum = 0;
        for(int i=0; i<length; i++){
            arraySum += nums[i];
        }

        return totalSum - arraySum;
    }
}