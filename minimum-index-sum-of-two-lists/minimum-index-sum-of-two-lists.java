class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> hm = new HashMap<>();
        
        for(int i=0; i<list1.length; i++){
            hm.put(list1[i], i);
        }
        
        int minCount = Integer.MAX_VALUE;
        List<String> result = new ArrayList<>();
        for(int i=0; i<list2.length; i++) {
            if(hm.containsKey(list2[i])) {
                int sum = hm.get(list2[i]) + i;
                if(minCount == sum)
                    result.add(list2[i]);
                else {
                    if(minCount > sum) {
                        result.clear();
                        minCount = sum;
                        result.add(list2[i]);
                    }
                }
            }
        }
        
        String[] res = new String[result.size()];
        for(int i=0; i<result.size(); i++) {
            res[i] = result.get(i);
        }
        
        return res;
    }
}