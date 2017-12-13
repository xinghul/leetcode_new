class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> tried = new HashSet<>();
        Queue<String> list = new LinkedList<>();

        list.add(beginWord);
        tried.add(beginWord);
        int length = 0;
        boolean found = false;

        while (!found && !list.isEmpty())
        {
          Queue<String> tmp = new LinkedList<>();
          length++;

          while (!list.isEmpty())
          {
            String word = list.poll();

            if (word.equals(endWord)) {
              found = true;

              break;
            }

            for (String str: wordList)
            {
              if (!tried.contains(str) && distance(word, str) == 1) {
                tmp.add(str);

                tried.add(str);
              }
            }
          }

          list = tmp;
        }

        if (!found) {
          return 0;
        }

        return length;
    }

    private int distance(String str1, String str2) {
      int count = 0;

      for (int i = 0; i < str1.length(); i++)
      {
        if (str1.charAt(i) != str2.charAt(i)) {
          count++;
        }
      }

      return count;
    }
}