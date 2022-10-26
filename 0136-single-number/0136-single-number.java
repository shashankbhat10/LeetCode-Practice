class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        Set<Integer> set = new HashSet<Integer>();
        
        for(int i : nums){
            hm.put(i, hm.getOrDefault(i, 0) + 1);
            set.add(i);
        }
        
        // Set<Integer> keys = hm.keySet();
        int result = nums[0];
        for(int key : set){
            if(hm.get(key) == 1)
                result = key;
        }
        
        return result;
    }
}