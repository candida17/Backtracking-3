// Time Complexity : O(m*n*3^L) where L is the length of the word
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//We perform DFS with backtracking we start with the cell whose character matches the first letter of word
//we recursively check for all its neighbors in right, top, left and down and also backtrack if no valid path found
class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        int [][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        for(int i = 0; i < m; i++) {
            for(int j = 0; j <n; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(backtrack(board, word, i, j, 0, dirs)) return true;
                }
            }
        }
        return false;
        
    }

    private boolean backtrack(char[][] board, String word, int i ,int j, int idx, int[][] dirs) {
       
        //base
        if (idx == word.length()) {
            return true;
        }
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '#') return false;
        
        //logic
        if(board[i][j] == word.charAt(idx)) {
            //only then you proceed
            board[i][j] = '#'; //visited
            //iterate over the neighbours
            for(int[] dir: dirs) {
                int nr = dir[0] + i;
                int nc = dir[1] + j;
                if(backtrack(board, word, nr, nc, idx + 1, dirs)) return true;
            }
            //backtrack
            board[i][j] = word.charAt(idx);
        }
        return false;
    }
}
