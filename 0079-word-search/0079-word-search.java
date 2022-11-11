class Solution {
    public boolean exist(char[][] board, String word) {
        int[][] visited = new int[board.length][board[0].length];
        
        char[] wordArr = word.toCharArray();
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == wordArr[0])
                    if(findWord(board, wordArr, 0, i, j, visited))
                        return true;
            }
        }
        return false;
    }
    
    private boolean findWord(char[][] board, char[] word, int index, int i, int j, int[][] visited){
        if(index == word.length)
            return true;
                
        if(i >= board.length || i < 0 || j < 0 || j >= board[0].length)
            return false;
        
        if(visited[i][j] == 1)
            return false;
        
        boolean result = false;
        if(board[i][j] == word[index]){
            visited[i][j] = 1;
            result = findWord(board, word, index+1, i-1, j, visited) || findWord(board, word, index+1, i, j+1, visited) || findWord(board, word, index+1, i+1, j, visited) || findWord(board, word, index+1, i, j-1, visited);
        }
        
        visited[i][j] = 0;
        
        return result;
    }
}