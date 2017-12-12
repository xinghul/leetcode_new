class Solution {
    // 11, 1
    public String addBinary(String a, String b) {
        int carry = 0;
        
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0)
        {
          int v1 = 0;
          int v2 = 0;

          if (i >= 0) {
            v1 = Character.getNumericValue(a.charAt(i));
          }
          if (j >= 0) {
            v2 = Character.getNumericValue(b.charAt(j));
          }

          int sum = v1 + v2 + carry;
          sb.insert(0, sum % 2);

          carry = sum / 2;

          i--;
          j--;
        }

        if (carry == 1) {
          sb.insert(0, '1');
        }

        return sb.toString();
    }
}