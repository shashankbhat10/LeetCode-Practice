class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        
        int count = 0;
        hm.put(0, 1);
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            if(hm.containsKey(sum - k)){
                count += hm.get(sum - k);
            }
            
            hm.put(sum, hm.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }
}