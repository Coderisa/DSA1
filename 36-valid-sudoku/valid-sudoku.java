import java.util.*;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Use sets to track seen digits
        Set<String> seen = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char digit = board[i][j];
                if (digit != '.') {
                    // Create unique keys for row, column, and box
                    String rowKey = digit + " in row " + i;
                    String colKey = digit + " in col " + j;
                    String boxKey = digit + " in box " + (i / 3) + "-" + (j / 3);

                    // Check for duplicates
                    if (!seen.add(rowKey) || !seen.add(colKey) || !seen.add(boxKey)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
