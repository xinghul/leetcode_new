class Solution {
    public String reverseVowels(String s) {
        char[] chs = s.toCharArray();

        int i = 0;
        int j = chs.length - 1;

        while (i < j) {
          while (i < j && !isVowel(chs[i])) {
            i++;
          }

          while (j > i && !isVowel(chs[j])) {
            j--;
          }

          if (i < j) {
            char c = chs[i];
            chs[i] = chs[j];
            chs[j] = c;
          }

          i++;
          j--;
        }

        return new String(chs);
    }

    private boolean isVowel(char c) {
      return "aeiou".indexOf(Character.toLowerCase(c)) != -1;
    }
}