class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (int[] i, int[] j) -> j[1] - i[1]);
        
        int count = 0;
        int units = 0;
        for(int i=0; i<boxTypes.length; i++){
            int tempBox = count + boxTypes[i][0];
            int min = Math.min(tempBox, truckSize);
            if(tempBox == min){
                units += boxTypes[i][0] * boxTypes[i][1];
                count += boxTypes[i][0];
            } else {
                units += (truckSize - count) * boxTypes[i][1];
                break;
            }
        }
        
        return units;
    }
}