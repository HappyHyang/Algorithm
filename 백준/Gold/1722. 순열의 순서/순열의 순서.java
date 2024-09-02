import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long[] factorials;

	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(input.readLine());

		factorials = calcFactorial(N);
		boolean[] visited = new boolean[N + 1];

		StringTokenizer tokenizer = new StringTokenizer(input.readLine());
		StringBuilder output = new StringBuilder();
		int type = Integer.parseInt(tokenizer.nextToken());
		switch (type) {
			case 1:
				long K = Long.parseLong(tokenizer.nextToken()) - 1;
				for (int i = N; i > 0; i--) {
					long k = K / factorials[i - 1] + 1;
					K %= factorials[i - 1];
					long cnt = 0;
					int idx = 0;
					while (cnt != k) {
						idx++;
						if (!visited[idx]) {
							cnt++;
						}
					}
					visited[idx] = true;
					output.append(idx).append(' ');
				}
				break;
			case 2:
				long k = 1;
				for (int i = N; i > 0; i--) {
					int data = Integer.parseInt(tokenizer.nextToken());
					int idx = 0;
					int cnt = 0;
					while (idx != data) {
						idx++;
						if (!visited[idx]) {
							cnt++;
						}
					}
					visited[idx] = true;
					k += (cnt - 1) * factorials[i - 1];
				}
				output.append(k);
				break;
		}

		System.out.println(output.toString().trim());
	}

	static long[] calcFactorial(int n) {
		long[] factorials = new long[n + 1];
		factorials[0] = 1;
		for (int i = 1; i <= n; i++) {
			factorials[i] = factorials[i - 1] * i;
		}
		return factorials;
	}
}