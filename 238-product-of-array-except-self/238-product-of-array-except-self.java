class Solution {
    public int[] productExceptSelf(int[] nums) {
        // Version 1 with 2 arrays
//         int[] pref = new int[nums.length];
//         pref[0] = 1;
//         int[] suff = new int[nums.length];
//         suff[nums.length-1] = 1;
        
//         for(int i=1; i<nums.length; i++){
//             pref[i] = pref[i-1] * nums[i-1];
//         }
        
//         for(int i=nums.length -2; i>=0; i--){
//             suff[i] = suff[i+1] * nums[i+1];
//         }
        
//         int[] result = new int[nums.length];
//         for(int i=0; i<nums.length; i++){
//             System.out.println(pref[i] + " " + suff[i]);
//             result[i] = pref[i] * suff[i];
//         }
        
//         return result;
        
        
        // Version 2 with constant space
        int[] result = new int[nums.length];
        Arrays.fill(result, 1);
        
        int curr = 1;
        for(int i=0; i<nums.length; i++){
            result[i] *= curr;
            curr *= nums[i];
        }
        
        curr = 1;
        for(int i=nums.length-1; i>=0; i--){
            result[i] *= curr;
            curr *= nums[i];
        }
        
        return result;
    }
}