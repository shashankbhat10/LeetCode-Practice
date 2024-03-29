class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(a[0] == b[0])
                    return b[1] - a[1];
                return a[0] - b[0];
            }
        });
        
        
        int max = Integer.MIN_VALUE;
        int result = 0;
        
        for(int i=properties.length - 1; i >= 0; i--){
            if(properties[i][1] < max)
                result++;
            
            max = Math.max(max, properties[i][1]);
        }
        return result;
    }
}