class Solution {
    public int findLonelyPixel(char[][] picture) {
        int count = 0;
        int[] row = new int[picture.length];
        int[] col = new int[picture[0].length];
        
        for(int i=0; i<picture.length; i++){
            for(int j=0; j<picture[0].length; j++){
                row[i] += picture[i][j] == 'W' ? 1: 0;
                col[j] += picture[i][j] == 'W' ? 1: 0;
            }
        }
        
        for(int i=0; i<picture.length; i++){
            for(int j=0; j<picture[0].length; j++){
                if(picture[i][j] == 'B' && row[i] == picture[0].length - 1 && col[j] == picture.length - 1)
                    count++;
            }
        }
        
        return count;
        
        // int m = picture.length, n = picture[0].length;
        // int[] row = new int[m];
        // int[] col = new int[n];
        // int res = 0;
        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         row[i] += picture[i][j] == 'W' ? 1 : 0;
        //         col[j] += picture[i][j] == 'W' ? 1 : 0;
        //     }
        // }
        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         if (picture[i][j] == 'B' && row[i] == n - 1 && col[j] == m - 1) {
        //             res++;
        //         }
        //     }
        // }
        // return res;
    }
}