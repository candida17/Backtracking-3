// Time Complexity : O(n * n!)
// Space Complexity : O(n^2) for the matrix + O(n) recursive stack 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//We recurse through every row and check if its safe to place the queen if yes we recursivley check for other rows and backtrack them
//When placing a queen in particular row we check for top colums in prev rows, also check diagonally top left and top right
//When all the rows are filled we check if the particular cell has a queen we convert and place it in a string as Q else as "."
class Solution {
    public List<List<String>> solveNQueens(int n) {
        boolean [][] grid = new boolean[n][n];
        List<List<String>> res = new ArrayList<>();
        backtrack(grid, 0, n, res);
        return res;
    }

    private void backtrack(boolean [][] grid , int r, int n, List<List<String>> res) {
        //base
        if (r == n) {// covered all rows
            //place the queens in list
            List<String> li = new ArrayList<>();
            for(int i = 0; i<n; i++) {
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < n; j++) {
                    if(grid[i][j]) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                li.add(sb.toString());
            }
            res.add(li);
        }


        //logic
        for(int c=0; c<n ; c++) { //iterate over each row to check if its safe to place the queen
            if(isSafe(grid, r, c, n)) {
                //action
                grid[r][c] = true;
                //recurse
                backtrack(grid, r+1, n, res);
                //backtrack
                grid[r][c] = false;
            } 
        }
    }

    private boolean isSafe(boolean[][] grid, int r, int c, int n) {
        //column up
        for(int i = 0; i < r; i++) {
            if(grid[i][c]) return false; //unsafe to place the queen here
        }

        //diagonal top left
        int i = r; int j = c; 
        while(i >=0 && j >= 0) {
            if(grid[i][j]) return false; //unsafe to place the queen here
            i--; j--;
        }

        //diagonal top right
        i = r; j = c; 
        while(i >=0 && j < n) {
            if(grid[i][j]) return false; //unsafe to place the queen here
            i--; j++;
        }
        return true;
    }
}
