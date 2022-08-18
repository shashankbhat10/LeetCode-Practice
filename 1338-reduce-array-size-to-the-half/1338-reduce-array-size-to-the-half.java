class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        
        for(int num : arr){
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }
        
        List<Integer> counts = new ArrayList<>(hm.values());
        Collections.sort(counts);
        Collections.reverse(counts);
        
        int totalRemoval = 0;
        int numRemoved = 0;
        for(int count : counts){
            numRemoved += 1;
            totalRemoval += count;
            if(totalRemoval >= arr.length / 2)
                break;
        }
        
        return numRemoved;
    }
}