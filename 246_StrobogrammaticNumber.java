class Solution {
    public boolean isStrobogrammatic(String num) {
        int i = 0;
		int j = num.length() - 1;

		while (i <= j)
		{
			switch (num.charAt(i)) {
				case '6':
					if (num.charAt(j) != '9') {
						return false;
					}
					break;
				case '9':
					if (num.charAt(j) != '6') {
						return false;
					}
					break;
				case '0':
				case '1':
				case '8':
					if (num.charAt(j) != num.charAt(i)) {
						return false;
					}
					break;

				default:
					return false;
			}

			i++;
			j--;
		}

		return true;
    }
}