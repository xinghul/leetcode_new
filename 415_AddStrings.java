class Solution {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
		int j = num2.length() - 1;

		String result = "";
		int carry = 0;
		while (i >= 0 || j >= 0)
		{
			int value1 = 0;
			if (i >= 0) {
				value1 = Character.getNumericValue(num1.charAt(i));
			}
			int value2 = 0;
			if (j >= 0) {
				value2 = Character.getNumericValue(num2.charAt(j));
			}

			int sum = value1 + value2 + carry;
			carry = sum / 10;

			result = sum % 10 + result;

			i--;
			j--;
		}

		if (carry == 1) {
			result = 1 + result;
		}

		return result;
    }
}