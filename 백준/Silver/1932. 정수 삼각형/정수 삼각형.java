import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	// input
	static int N;
	static int[][] triangle;

	public static void main(String[] args) throws IOException {
		initialize();
		System.out.println(solution());
	}

	static void initialize() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(input.readLine());
		triangle = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer tokenizer = new StringTokenizer(input.readLine());
			for (int j = 0; j <= i; j++) {
				triangle[i][j] = Integer.parseInt(tokenizer.nextToken());
			}
		}
	}

	static int solution() {
		int[][] dp = new int[N][N];
		dp[0][0] = triangle[0][0];
		for (int i = 1; i < N; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0) {
					dp[i][j] = dp[i - 1][j] + triangle[i][j];
				} else if (j == i) {
					dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
				}
			}
		}
		return Arrays.stream(dp[N - 1]).max().getAsInt();
	}
}