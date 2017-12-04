class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
          return 0;
        }

        int count = 0;
        boolean[][] checked = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++)
        {
          for (int j = 0; j < grid[0].length; j++)
          {
            if (!checked[i][j] && grid[i][j] == '1') {
              count++;

              expand(checked, grid, i, j);
            }
          }
        }

        return count;
    }

    private void expand(boolean[][] checked, char[][] grid, int i, int j)
    {
      if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
        return;
      }

      if (checked[i][j] || grid[i][j] == '0') {
        return;
      }

      checked[i][j] = true;

      expand(checked, grid, i - 1, j);
      expand(checked, grid, i + 1, j);
      expand(checked, grid, i, j - 1);
      expand(checked, grid, i, j + 1);
    }
}