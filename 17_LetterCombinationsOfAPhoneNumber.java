class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
          return new ArrayList<String>();
        }
        
        char[][] map = new char[][]{
          {},
          {},
          {'a', 'b', 'c'},
          {'d', 'e', 'f'},
          {'g', 'h', 'i'},
          {'j', 'k', 'l'},
          {'m', 'n', 'o'},
          {'p', 'q', 'r', 's'},
          {'t', 'u', 'v'},
          {'w', 'x', 'y', 'z'}
        };

        List<String> result = new ArrayList<>();
        result.add("");

        for (int i = 0; i < digits.length(); i++)
        {
          int index = Character.getNumericValue(digits.charAt(i));
          char[] chs = map[index];

          List<String> tmp = new ArrayList<>();
          
          for (char ch: chs) {
            for (String str: result) {
              tmp.add(str + ch);
            }
          }

          result = tmp;
        }

        return result;
    }
}