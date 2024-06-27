import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();

	static int[] dp = new int[11];

	public static void main(String[] args) throws IOException {
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for (int i = 4; i < 11; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		}

		int TC = Integer.parseInt(input.readLine());
		for (int tc = 0; tc < TC; tc++) {
			int N = Integer.parseInt(input.readLine());
			output.append(dp[N] + "\n");
		}
		System.out.print(output);
	}
}