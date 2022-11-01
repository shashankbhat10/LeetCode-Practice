class Solution {
    public int smallestCommonElement(int[][] mat) {
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                hm.put(mat[i][j], hm.getOrDefault(mat[i][j], 0) + 1);
            }
        }
        
        int minEl = Integer.MAX_VALUE;
        for(int key : hm.keySet()){
            if(hm.get(key) == mat.length){
                minEl = Math.min(minEl, key);
            }
        }
        
        return minEl == Integer.MAX_VALUE ? -1 : minEl;
    }
}