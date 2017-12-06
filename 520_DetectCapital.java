class Solution {
    public boolean detectCapitalUse(String word) {
        if (word.length() <= 1) {
			return true;
		}

		if (word.charAt(0) >= 'a') {
			// all lowercase 1...length - 1
			return word.toLowerCase().equals(word);
		} else {
			if (word.charAt(1) >= 'a') {
				// all lowercase 2...length - 1
				return word.substring(1).toLowerCase().equals(word.substring(1));
			} else {
				// all uppercase 2...length - 1
				return word.toUpperCase().equals(word);
			}
		}
    }
}