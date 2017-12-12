class Solution {
    public boolean exist(char[][] board, String word) {
        if (word.length() == 0) {
          return true;
        }
        if (board.length == 0) {
          return false;
        }

        boolean[][] checked = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++)
        {
          for (int j = 0; j < board[0].length; j++)
          {
            if (board[i][j] == word.charAt(0) && formWord(board, checked, word, i, j)) {
              return true;
            }
          }
        }

        return false;
    }

    private boolean formWord(char[][] board, boolean[][] checked, String word, int i, int j) {
      if (word.length() == 0) {
        return true;
      }
      if (i < 0 || i >= board.length) {
        return false;
      }
      if (j < 0 || j >= board[0].length) {
        return false;
      }
        
      if (board[i][j] != word.charAt(0) || checked[i][j]) {
        return false;
      }

      checked[i][j] = true;

      boolean found = formWord(board, checked, word.substring(1), i + 1, j) ||
        formWord(board, checked, word.substring(1), i - 1, j) ||
        formWord(board, checked, word.substring(1), i, j + 1) ||
        formWord(board, checked, word.substring(1), i, j - 1);

      checked[i][j] = false;

      return found;
    }
}