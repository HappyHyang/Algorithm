import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(input.readLine());

		if (N < 3) {
			System.out.println(N);
			return;
		}
		int[] dp = new int[N + 1];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= N; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 10_007;
		}

		System.out.println(dp[N]);
	}
}