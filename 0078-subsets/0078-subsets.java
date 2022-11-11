class Solution {
    List<List<Integer>> result=new ArrayList<List<Integer>>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list=new ArrayList<Integer>();
        func(0,nums,list);
        return result;
    }
    
    void func(int pos ,int[] nums,List<Integer> list){
       if(pos==nums.length){
           result.add(list);
            return;
       }
        
        func(pos+1, nums, list);
        list = new ArrayList<Integer>(list);
        list.add(nums[pos]);
        func(pos+1, nums, list);          
    } 
}