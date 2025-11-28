import java.util.*;

class Solution {
    // Check if it's safe to place a queen at board[row][col]
    private boolean isSafe(List<String> board, int row, int col) {
        int r = row, c = col;

        // Check for upper left diagonal
        while (r >= 0 && c >= 0) {
            if (board.get(r).charAt(c) == 'Q') return false;
            r--;
            c--;
        }

        // Reset to the original position
        r = row;
        c = col;

        // Check for top
        while (r >= 0) {
            if (board.get(r).charAt(c) == 'Q') return false;
            r--;
        }

        // Reset to the original position
        r = row;
        c = col;

        // Check for top right diagonal
        while (r >= 0 && c < board.get(0).length()) {
            if (board.get(r).charAt(c) == 'Q') return false;
            r--;
            c++;
        }

        // If no queens are found, it's safe
        return true;
    }

    // Function to place queens on the board
    private void func(int row, List<List<String>> ans, List<String> board) {
        // If all columns are filled, add the solution to the answer
        if (row == board.size()) {
            ans.add(new ArrayList<>(board));
            return;
        }

        // Try placing a queen in each column for the current row
        for (int col = 0; col < board.get(0).length(); col++) {
            // Check if it's safe to place a queen
            if (isSafe(board, row, col)) {
                // Place the queen
                char[] rowArr = board.get(row).toCharArray();
                rowArr[col] = 'Q';
                board.set(row, new String(rowArr));

                // Recursively place queens in the next rows
                func(row + 1, ans, board);

                // Remove the queen and backtrack
                rowArr[col] = '.';
                board.set(row, new String(rowArr));
            }
        }
    }

    // Solve the N-Queens problem
    public List<List<String>> solveNQueens(int n) {
        // List to store the solutions
        List<List<String>> ans = new ArrayList<>();
        // Initialize the board with empty cells
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            board.add(".".repeat(n));
        }

        // Start placing queens from the first column
        func(0, ans, board);
        return ans;
  
}

class Nqueens {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 8; 
        List<List<String>> solutions = solution.solveNQueens(n);

        // Print all solutions
        for (List<String> sol : solutions) {
            for (String row : sol) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}

