class Solution {
    public String solution(String s, int n) {
        StringBuilder output = new StringBuilder();
		for (char c : s.toCharArray()) {
			output.append(push(c, n));
		}
		return output.toString();
    }
    
    private char push(char c, int n) {
		if (!Character.isAlphabetic(c)) {
			return c;
		}

		int offset = Character.isUpperCase(c) ? 'A' : 'a';
		int position = c - offset;
		position = (position + n) % ('Z' - 'A' + 1);
		return (char)(offset + position);
	}
}