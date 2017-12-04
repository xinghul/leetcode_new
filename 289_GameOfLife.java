class Solution {
    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++)
        {
          for (int j = 0; j < board[0].length; j++)
          {
            int count = getLiveNeighbors(i, j, board);

            if ((board[i][j] & 1) == 1 && (count == 2 || count == 3)) {
              board[i][j] = 3;
            }
            if ((board[i][j] & 1) == 0 && count == 3) {
              board[i][j] = 2;
            }
          }
        }

        for (int i = 0; i < board.length; i++)
        {
          for (int j = 0; j < board[0].length; j++)
          {
            board[i][j] >>= 1;
          }
        }
    }

    private int getLiveNeighbors(int m, int n, int[][] board) {
      int count = 0;
      
      for (int i = Math.max(m - 1, 0); i <= Math.min(board.length - 1, m + 1); i++)
      {
        for (int j = Math.max(n - 1, 0); j <= Math.min(board[0].length - 1, n + 1); j++)
        {
          count += board[i][j] & 1;
        }
      }

      count -= board[m][n] & 1;

      return count;
    }
}