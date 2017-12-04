// naive approach
class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public int numSquares(int n) {
        // DP: use map to avoid re-calculation
        // for given number, try out all possbile sequences
        // for tryNumber call, try at least n ^ 1/2 times
        map.put(0, 0);

        return tryNumber(n);
    }

    private int tryNumber(int n) {
        if (map.containsKey(n)) {
          return map.get(n);
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i*i <= n; i++)
        {
          min = Math.min(min, 1 + tryNumber(n - i * i));
        }

        map.put(n, min);

        return min;
    }
}

// BFS
class Solution {
    public int numSquares(int n) {
      // since it's a tree
      // use BFS will find the shortest path faster
      Set<Integer> toCheck = new HashSet<>();

      toCheck.add(n);
      int count = 0;
      while (!toCheck.isEmpty())
      {
          count++;
          Set<Integer> tmp = new HashSet<>();

          for (int num: toCheck)
          {
            for (int i = 1; i*i <= num; i++)
            {
                if (num == i*i) {
                    return count;
                }

                tmp.add(num - i*i);
            }
          }

          toCheck = tmp;
      }

      return count;
    }
}