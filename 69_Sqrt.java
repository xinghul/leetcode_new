class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
          return 0;
        }

        // find the most significant digit
        int h = 0;
        while ((long)(1 << h) * (long)(1 << h) <= x) {
          h++;
        }
        h--;

        int b = h - 1;
        int result = 1 << h;

        while (b >= 0)
        {
          if ((long)(result | (1 << b)) * (long)(result | (1 << b)) <= x) {
            result |= 1 << b;
          }

          b--;
        }

        return result;
    }
}