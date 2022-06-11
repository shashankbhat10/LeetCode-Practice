class Solution {
    public int minOperations(int[] nums, int x) {
        int totalSum = 0;
        
        for(int i=0; i<nums.length; i++){
            totalSum += nums[i];
        }
        
        int maxLength = -1;
        int currSum = 0;
        
        for(int l=0, r=0; r<nums.length; r++){
            currSum += nums[r];
            
            while(l <= r && currSum > totalSum - x){
                currSum -= nums[l++];
            }
            
            if(currSum == totalSum - x){
                maxLength = Math.max(maxLength, r - l + 1);
            }
        }
        
        return maxLength == -1 ? -1 : nums.length - maxLength;
    }
}