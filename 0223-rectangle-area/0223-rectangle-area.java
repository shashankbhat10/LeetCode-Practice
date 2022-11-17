class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
//         int commonArea = 0;
//         if(ax2 < bx1 || ay2 < by1)
//             commonArea = 0;
//         else
//             commonArea = (ax2-bx1)*(by2-ay1);
        
//         int area1 = (ax2-ax1) * (ay2-ay1);
//         int area2 = (bx2 - bx1) * (by2 - by1);
        
//         return area1 + area2 - commonArea;
        int A = ax1;
        int B = ay1;
        int C = ax2;
        int D = ay2;
        int E = bx1;
        int F = by1;
        int G = bx2;
        int H = by2;
        int areaOfSqrA = (C-A) * (D-B);
        int areaOfSqrB = (G-E) * (H-F);
        
        int left = Math.max(A, E);
        int right = Math.min(G, C);
        int bottom = Math.max(F, B);
        int top = Math.min(D, H);
        
        //If overlap
        int overlap = 0;
        if(right > left && top > bottom)
             overlap = (right - left) * (top - bottom);
        
        return areaOfSqrA + areaOfSqrB - overlap;
    }
}