import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static char[] word1, word2;

	public static void main(String[] args) throws IOException {
		initialize();
		System.out.println(LCS());
	}

	static void initialize() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		word1 = input.readLine().toCharArray();
		word2 = input.readLine().toCharArray();
	}

	static int LCS() {
		int[][] dp = new int[word1.length + 1][word2.length + 1];

		for (int i = 1; i <= word1.length; i++) {
			for (int j = 1; j <= word2.length; j++) {
				if (word1[i - 1] == word2[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		return dp[word1.length][word2.length];
	}
}