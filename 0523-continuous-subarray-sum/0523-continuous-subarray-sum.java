class Solution {    
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            
            sum %= k;
            if(sum == 0 && i > 0)
                return true;
            
            if(hm.containsKey(sum) && (i - hm.get(sum)) > 1)
                return true;
            
            if(!hm.containsKey(sum))
                hm.put(sum, i);
        }
        
        return false;
    }
}