import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int TC = Integer.parseInt(input.readLine());
		for (int tc = 0; tc < TC; tc++) {
			int N = Integer.parseInt(input.readLine());
			if (N < 3) {
				output.append(1 + "\n");
				continue;
			}

			long[] dp = new long[N + 1];
			dp[1] = 1;
			dp[2] = 1;
			dp[3] = 1;
			for (int i = 4; i <= N; i++) {
				dp[i] = dp[i - 2] + dp[i - 3];
			}
			output.append(dp[N] + "\n");
		}
		System.out.print(output);
	}
}