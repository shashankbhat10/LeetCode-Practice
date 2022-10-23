class Solution {
    public int[] findErrorNums(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        
        for(int num : nums){
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }
        
        int res[] = new int[2];
        for(int i=0; i<nums.length; i++){
            if(!hm.containsKey(i+1))
                res[1] = i+1;
            else if(hm.get(i+1) == 2)
                res[0] = i+1;
        }
        return res;
    }
}