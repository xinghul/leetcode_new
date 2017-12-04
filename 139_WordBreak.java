class Solution {
    Set<String> canBreak = new HashSet<>();
    Set<String> cantBreak = new HashSet<>();

    public boolean wordBreak(String s, List<String> wordDict) {
      canBreak.add("");

      return canBreakSubString(s, wordDict);
    }

    private boolean canBreakSubString(String s, List<String> wordDict) {
      if (canBreak.contains(s)) {
        return true;
      }
      if (cantBreak.contains(s)) {
        return false;
      }

      boolean flag = false;
      for (String prefix: wordDict)
      {
        if (s.startsWith(prefix) && wordBreak(s.substring(prefix.length()), wordDict)) {
          flag = true;

          break;
        }
      }

      if (flag) {
        canBreak.add(s);
      } else {
        cantBreak.add(s);
      }

      return flag;
    }
}