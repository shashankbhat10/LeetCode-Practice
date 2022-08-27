class Solution {
    public boolean containsDuplicate(int[] nums) {
        // Set<Integer> hs = new HashSet<>();
        // for(int num : nums){
        //     if(hs.contains(num))
        //         return true;
        //     else
        //         hs.add(num);
        // }
        // return false;
        
        Set<Integer> set = new HashSet<>();
        
        for(int i=0; i<nums.length; i++){
            if(set.contains(nums[i]))
                return true;
            
            set.add(nums[i]);
        }
        
        return false;
    }
}