class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // the idea is to rule out at least one row or one column at a time
        if (matrix.length == 0) {
          return false;
        }

        int row = 0, col = matrix[0].length - 1;

        // since we search at most m + n times
        // O(m + n)
        while (row < matrix.length && col >= 0)
        {
            int val = matrix[row][col];

            if (val == target) {
              return true;
            } else if (val < target) {
              // entire row is impossible, search down
              row++;
            } else {
              // entire col is impossible, search left
              col--;
            }
        }

        return false;
    }
}