class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        
        for(int i : nums){
            hm.put(i, hm.getOrDefault(i, 0) + 1);
        }
        
        Set<Integer> keys = hm.keySet();
        int result = nums[0];
        for(int key : keys){
            if(hm.get(key) == 1)
                result = key;
        }
        
        return result;
    }
}