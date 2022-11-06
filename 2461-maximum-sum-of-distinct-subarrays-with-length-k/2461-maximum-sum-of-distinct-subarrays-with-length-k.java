class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int totalMore = 0;
        int i=0;
        long maxSum = 0;
        long sum = 0;
        while(i < k){
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
            sum += nums[i];
            
            if(hm.get(nums[i]) == 2)
                totalMore++;
            
            if(totalMore > 0){
                maxSum = 0;
            } else {
                maxSum = sum;
            }
            i++;
        }
        
        while(i < nums.length){
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
            if(hm.get(nums[i]) == 2)
                totalMore++;
            
            hm.put(nums[i-k], hm.get(nums[i-k]) - 1);
            if(hm.get(nums[i-k]) == 1)
                totalMore--;
            
            sum += nums[i];
            sum -= nums[i-k];
            
            if(totalMore == 0)
                maxSum = Math.max(sum, maxSum);
            i++;
        }
        
        return maxSum;
    }
}