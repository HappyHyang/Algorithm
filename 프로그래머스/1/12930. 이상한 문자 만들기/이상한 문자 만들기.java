class Solution {
    public String solution(String s) {
        StringBuilder output = new StringBuilder();
		boolean toUpper = true;

		for (char c : s.toCharArray()) {
			if (Character.isSpaceChar(c)) {
				// 공백
				output.append(c);
				toUpper = true;
			} else {
				// 알파벳
				output.append(toUpper ? Character.toUpperCase(c) : Character.toLowerCase(c));
				toUpper = !toUpper;
			}
		}
		return output.toString();
    }
}