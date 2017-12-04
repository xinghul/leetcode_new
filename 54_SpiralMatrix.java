class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();

        if (matrix.length == 0) {
          return list;
        }

        visit(matrix, list, 0, 0);

        return list;
    }

    private void visit(int[][] matrix, List<Integer> list, int x, int y) {
      int row = matrix.length - 1;
      int col = matrix[0].length - 1;

      for (int i = x; i <= col - x; i++) list.add(matrix[y][i]);
      for (int i = y + 1; i <= row - y; i++) list.add(matrix[i][col - x]);

      if (row - y > y) {
        for (int i = col - x - 1; i >= x; i--) list.add(matrix[row - y][i]);
      }
      if (x < col - x) {
        for (int i = row - y - 1; i > y; i--) list.add(matrix[i][x]);
      }

      if (row - y - 1 > y &&  col - x - 1 > x) {
        visit(matrix, list, x + 1, y + 1);
      }
    }
}