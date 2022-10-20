class Solution {
    public int firstMissingPositive(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int max = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] > 0){
                hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
                max = Math.max(max, nums[i]);
            }
        }
        
        int i=1;
        int res = 0;
        if(hm.isEmpty()){
            return 1;
        }
        while(i <= max){
            System.out.println(i);
            if(!hm.containsKey(i)){
                // System.out.println("i: " + i);
                res = i;
                break;
            }
            i++;
        }
        
        // System.out.println(res + ", " + i);
        if(res == 0)
            res = i;
        return res;
    }
}