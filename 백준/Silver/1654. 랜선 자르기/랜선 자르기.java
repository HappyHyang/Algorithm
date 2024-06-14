import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens = null;

	// input: K(랜선의 개수), N(필요한 랜선의 개수), CABLE(랜 선)
	static int K, N, CABLE[];

	static long min, mid, max = 0;

	public static void main(String[] args) throws Exception {
		// input
		tokens = new StringTokenizer(input.readLine());
		K = Integer.parseInt(tokens.nextToken());
		N = Integer.parseInt(tokens.nextToken());
		CABLE = new int[K];
		for (int k = 0; k < K; k++) {
			CABLE[k] = Integer.parseInt(input.readLine());
			max = Math.max(max, CABLE[k]);
		}

		max++;
		while (min < max) {
			int cnt = 0; // 만들어지는 케이블의 수

			mid = (max + min) / 2;
			for (int k = 0; k < K; k++) {
				cnt += CABLE[k] / mid;
			}

			if (N <= cnt) {
				min = mid + 1;
			} else {
				max = mid;
			}
		}

		// output
		System.out.println(min - 1);
	}
}