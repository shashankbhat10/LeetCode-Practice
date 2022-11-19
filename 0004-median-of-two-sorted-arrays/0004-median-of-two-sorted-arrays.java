class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        
        int i = 0;
        int j = 0;
        int count = 0;
        while(count <= (nums1.length + nums2.length - 1)){
            if(i > nums1.length-1){
                nums[count++] = nums2[j++];
            } else if (j > nums2.length-1){
                nums[count++] = nums1[i++];
            } else if(nums1[i] <= nums2[j]){
                nums[count++] = nums1[i++];
            } else {
                nums[count++] = nums2[j++];
            }
        }
        
        return nums.length % 2 == 1 ? nums[(count)/2] : (nums[count/2] + nums[(count/2)-1])/2.0;
    }
}