/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int upper = n;
        int lower = 1;
        
        while (lower < upper) {
          if (guess(lower) == 0) {
            return lower;
          }
          if (guess(upper) == 0) {
            return upper;
          }

          int tmp = lower + (upper - lower) / 2;
          int result = guess(tmp);

          if (result == 0) {
            return tmp;
          } else if (result == -1) {
            upper = tmp - 1;
            lower += 1;
          } else {
            lower = tmp + 1;
            upper -= 1;
          }
        }

        return lower + (upper - lower) / 2;
    }
}