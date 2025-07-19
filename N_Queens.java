import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        boolean[] rowf = new boolean[n];          
        boolean[] colf = new boolean[n];         
        boolean[] d1f = new boolean[2 * n - 1];   
        boolean[] d2f = new boolean[2 * n - 1];  //6 

        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];

        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.'; 
            }
        }

        solve(rowf, colf, d1f, d2f, result, 0, n, board);
        return result;
    }

    private void solve(boolean[] rowf, boolean[] colf, boolean[] d1f, boolean[] d2f,
                      List<List<String>> result, int row, int n, char[][] board) {
        if (row == n) {
            List<String> combo = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                combo.add(new String(board[i])); 
            }
            result.add(combo);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (!rowf[row] && !colf[col] && !d1f[row + col] && !d2f[n - 1 - row + col]) {
              
                board[row][col] = 'Q';
                rowf[row] = true;
                colf[col] = true;
                d1f[row + col] = true;
                d2f[n - 1 - row + col] = true;

               
                solve(rowf, colf, d1f, d2f, result, row + 1, n, board);

                
                board[row][col] = '.';
                rowf[row] = false;
                colf[col] = false;
                d1f[row + col] = false;
                d2f[n - 1 - row + col] = false;
            }
        }
    }
}
