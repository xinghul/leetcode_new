class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        s = s.toLowerCase();

        while (i < j)
        {
          while (i < s.length() && !isAlphanumeric(s.charAt(i)))
          {
            i++;
          }
          while (j >= 0 && !isAlphanumeric(s.charAt(j)))
          {
            j--;
          }

          if (i < j && s.charAt(i) != s.charAt(j)) {
            return false;
          }

          i++;
          j--;
        }

        return true;
    }

    private boolean isAlphanumeric(char ch) {
      return '0' <= ch && ch <= '9' || 'a' <= ch && ch <= 'z';
    }
}