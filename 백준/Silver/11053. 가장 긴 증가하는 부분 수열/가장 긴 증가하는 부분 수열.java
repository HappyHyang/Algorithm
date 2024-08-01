import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N;
	static int[] progression;

	public static void main(String[] args) throws IOException {
		initialzie();
		System.out.println(longestIncreasingPartLength());
	}

	static void initialzie() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(input.readLine());
		progression = Arrays.stream(input.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
	}

	static int longestIncreasingPartLength() {
		int[] dp = new int[N];
		Arrays.fill(dp, 1);

		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (progression[j] < progression[i] && dp[j] + 1 > dp[i]) {
					dp[i] = dp[j] + 1;
				}
			}
		}
		return Arrays.stream(dp).max().getAsInt();
	}
}