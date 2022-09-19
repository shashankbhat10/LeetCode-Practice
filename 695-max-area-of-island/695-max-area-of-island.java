class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        
        int maxArea = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1 && visited[i][j] != 1){
                    int area = fill(grid, i, j, visited, 0);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        
        return maxArea;
    }
    
    public int fill(int[][] grid, int i, int j, int[][] visited, int area){
        if(i < 0 || j < 0 || i > grid.length-1 || j > grid[0].length-1 || visited[i][j] == 1 || grid[i][j] == 0)
            return 0;
        
        visited[i][j] = 1;
        return 1 + fill(grid, i+1, j, visited, area) + fill(grid, i-1, j, visited, area) + 
            fill(grid, i, j+1, visited, area) + fill(grid, i, j-1, visited, area);
    }
}