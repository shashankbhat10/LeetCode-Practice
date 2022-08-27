class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();
        
        for(int i : nums1){
            set1.add(i);
        }
        
        for(int i : nums2){
            set2.add(i);
        }
        
        if(set1.size() < set2.size()){
            return getIntersection(set1, set2);
        }
        
        return getIntersection(set2, set1);
    }
    
    public int[] getIntersection(Set<Integer> set1, Set<Integer> set2){
        int[] result = new int[set1.size()];
        
        int i = 0;
        for(Integer key : set1){
            if(set2.contains(key)){
                result[i++] = key;
            }
        }
        
        return Arrays.copyOf(result, i);
    }
}