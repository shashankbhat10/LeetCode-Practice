class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        
        int count = 0;
        int[][] visited = new int[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == '1' && visited[i][j] != 1){
                    // System.out.println(i + ", " + j);
                    fill(grid, i, j, visited);
                    visited[i][j] = 1;
                    count++;
                }
            }
        }
        return count;
    }
    
    private void fill(char[][] grid, int i, int j, int[][] visited){
        // System.out.println("here: " + i + ", " + j);
        if(i < 0 || j < 0 || i > grid.length-1 || j > grid[0].length-1 || visited[i][j] == 1 || grid[i][j] == '0')
            return;
        
        visited[i][j] = 1;
        fill(grid, i-1, j, visited);
        fill(grid, i+1, j, visited);
        fill(grid, i, j-1, visited);
        fill(grid, i, j+1, visited);
    }
}