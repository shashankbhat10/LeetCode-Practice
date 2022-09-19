class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<List<Integer>> q = new LinkedList<>();
        
        if(image == null || image.length == 0 || image[0].length == 0){
            return image;
        }
        if(color == image[sr][sc])
            return image;
        
        List<Integer> src = new ArrayList<Integer>();
        src.add(sr);
        src.add(sc);
        q.add(src);
        int srcColor = image[sr][sc];
        
        while(!q.isEmpty()){
            List<Integer> cell = q.remove();
            int r = cell.get(0);
            int c = cell.get(1);
            image[r][c] = color;
            System.out.println(r + ", " + c);
            
            if(r > 0 && image[r-1][c] == srcColor){
                List<Integer> newCell = new ArrayList<Integer>();
                newCell.add(r-1);
                newCell.add(c);
                q.add(newCell);
                image[r-1][c] = color;
            }
            if(r < image.length-1 && image[r+1][c] == srcColor){
                List<Integer> newCell = new ArrayList<Integer>();
                newCell.add(r+1);
                newCell.add(c);
                q.add(newCell);
                image[r+1][c] = color;
            }
            if(c > 0 && image[r][c-1] == srcColor){
                List<Integer> newCell = new ArrayList<Integer>();
                newCell.add(r);
                newCell.add(c-1);
                q.add(newCell);
                image[r][c-1] = color;
            }
            if(c < image[0].length-1 && image[r][c+1] == srcColor){
                List<Integer> newCell = new ArrayList<Integer>();
                newCell.add(r);
                newCell.add(c+1);
                q.add(newCell);
                image[r][c+1] = color;
            }
        }
        return image;
    }
}