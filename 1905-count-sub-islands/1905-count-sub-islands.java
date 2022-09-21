class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int[][] visited = new int[grid2.length][grid2[0].length];
        
        int count = 0;
        for(int i=0; i<grid2.length; i++){
            for(int j=0; j<grid2[0].length; j++){
                if(visited[i][j] == 0 && grid2[i][j] == 1 && checkSubIsland(grid1, grid2, i, j, visited)){
                    System.out.println(i + ", " + j);
                    count++;
                } 
                else if(grid2[i][j] == 1){
                    visited[i][j] = -1;
                }
            }
        }
        return count;
    }
    
    private boolean checkSubIsland(int[][] grid1, int[][] grid2, int i, int j, int[][] visited){
        if(i < 0 || j < 0 || i >= grid2.length || j >= grid2[0].length || visited[i][j] == -1 || grid2[i][j] == 0)
            return true;
        
        visited[i][j] = -1;
                  
        boolean up = checkSubIsland(grid1, grid2, i-1, j, visited);
        boolean down = checkSubIsland(grid1, grid2, i+1, j, visited);
        boolean right = checkSubIsland(grid1, grid2, i, j+1, visited);
        boolean left = checkSubIsland(grid1, grid2, i, j-1, visited);
        
        if(grid2[i][j] == grid1[i][j])
            return up && down && left && right;
        else return false;
        
        
    }
}