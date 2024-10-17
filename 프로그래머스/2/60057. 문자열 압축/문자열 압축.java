import java.util.*;

class Solution {
    public int solution(String s) {
        int min = Integer.MAX_VALUE;

		for (int len = 1; len <= s.length(); len++) {
			int compressed = compress(s, len);
			if (compressed < min) {
				min = compressed;
			}
		}

		return min;
    }
    
    private int compress(String source, int length) {
		StringBuilder builder = new StringBuilder();

		String last = "";
		int cnt = 0;
		for (String token : split(source, length)) {
			if (token.equals(last)) {
				cnt++;
			} else {
				if (cnt > 1) {
					builder.append(cnt);
				}
				builder.append(last);
				last = token;
				cnt = 1;
			}
		}
		if (cnt > 1) {
			builder.append(cnt);
		}
		builder.append(last);
		return builder.length();
	}

	private List<String> split(String source, int length) {
		List<String> tokens = new ArrayList<>();
		for (int startIdx = 0; startIdx < source.length(); startIdx += length) {
			int endIdx = startIdx + length;
			if (endIdx > source.length()) {
				endIdx = source.length();
			}
			tokens.add(source.substring(startIdx, endIdx));
		}
		return tokens;
	}
}