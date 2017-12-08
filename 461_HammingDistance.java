// 01001, 00110
// 0101, 01
// 0101, 0
class Solution {
    // O(max(m, n)), O(1)
    public int hammingDistance(int x, int y) {
        int count = 0;
        while (x > 0 || y > 0) {
          if ((x & 1) != (y & 1)) {
            count++;
          }

          x >>= 1;
          y >>= 1;
        }

        return count;
    }
}