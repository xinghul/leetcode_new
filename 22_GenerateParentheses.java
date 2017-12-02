/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * [
 *  "((()))",
 *  "(()())",
 *  "(())()",
 *  "()(())",
 *  "()()()"
 * ]
 */
class Solution {
    public List<String> generateParenthesis(int n) {
      // thought: generate string by adding open and close parenthesis one by one
      // as long as we have no less close parenthesis left than open parenthesis left at any given point
      // the partially generated string is still valid so far
      // use DFS, add open parenthesis first, then close parenthesis
      
      List<String> list = new ArrayList<>();

      generateParenthesisByOne(list, n, n, "");

      return list;
    }

    private void generateParenthesisByOne(List<String> list, int open, int close, String str) {
        if (open > close) {
            return;
        }

        if (open > 0) {
            generateParenthesisByOne(list, open - 1, close, str + '(');
        }
        if (close > 0) {
            generateParenthesisByOne(list, open, close - 1, str + ')');
        }

        if (open == 0 && close == 0) {
           list.add(str);
        }
    }
}