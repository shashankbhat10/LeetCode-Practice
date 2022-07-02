class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int[] diffH = new int[horizontalCuts.length + 1];
        int[] diffV = new int[verticalCuts.length + 1];
        
        for(int i=0; i<diffH.length; i++){
            if(i == 0){
                diffH[i] = horizontalCuts[i];
            } else if(i==diffH.length-1){
                diffH[i] = h - horizontalCuts[i-1];
            } else {
                diffH[i] = horizontalCuts[i] - horizontalCuts[i-1];
            }
        }
        
        for(int i=0; i<diffV.length; i++){
            if(i == 0){
                diffV[i] = verticalCuts[i];
            } else if(i == diffV.length-1){
                diffV[i] = w - verticalCuts[i-1];
            } else {
                diffV[i] = verticalCuts[i] - verticalCuts[i-1];
            }
        }
        
        int maxH = 0;
        int maxV = 0;
        
        for(int i=0; i<diffH.length; i++){
            System.out.println(diffH[i]);
            maxH = Math.max(maxH, diffH[i]);
        }
        
        for(int i=0; i<diffV.length; i++){
            System.out.println(diffV[i]);
            maxV = Math.max(maxV, diffV[i]);
        }
        
        System.out.println(maxH);
        System.out.println(maxV);
        
        long ans = 1L * maxH * maxV;
        System.out.println(ans);
        System.out.println(ans % 1000000007);
        
        return (int)(ans % 1000000007); 
    }
}