class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
          return 1;
        }

        if (n < 0) {
          x = 1 / x;

          if (n == Integer.MIN_VALUE) {
            n = Integer.MAX_VALUE;

            return x * x * myPow(x * x, n / 2);
          } else {
            n = -n;
          }
        }

        return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }
}