class Solution {
    boolean[][] checked;
    int perimeter = 0;
    int rowCount;
    int colCount;

    public int islandPerimeter(int[][] grid) {
        rowCount = grid.length;
        colCount = grid[0].length;
        checked = new boolean[rowCount][colCount];
        
        for (int i = 0; i < rowCount; i++)
        {
          for (int j = 0; j < colCount; j++)
          {
            if (grid[i][j] == 1) {
              expand(j, i, grid);

              break;
            }
          }
        }

        return perimeter;
    }

    private void expand(int x, int y, int[][] grid) {
      if (checked[y][x]) {
        return;
      }

      checked[y][x] = true;
      perimeter += 4;

      if (y > 0 && grid[y - 1][x] == 1) {
        perimeter -= 1;

        expand(x, y - 1, grid);
      }
      if (y < rowCount - 1 && grid[y + 1][x] == 1) {
        perimeter -= 1;

        expand(x, y + 1, grid);
      }
      if (x > 0 && grid[y][x - 1] == 1) {
        perimeter -= 1;

        expand(x - 1, y, grid);
      }
      if (x < colCount - 1 && grid[y][x + 1] == 1) {
        perimeter -= 1;

        expand(x + 1, y, grid);
      }
    }
}