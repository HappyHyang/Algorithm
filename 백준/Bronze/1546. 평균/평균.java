import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens = null;

	static int N, M, scores[];

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());
		M = 0;

		tokens = new StringTokenizer(input.readLine());
		scores = new int[N];
		double total = 0;
		for (int n = 0; n < N; n++) {
			scores[n] = Integer.parseInt(tokens.nextToken());
			total += scores[n];
			if (scores[n] > M) {
				M = scores[n];
			}
		}
		System.out.println((total / M * 100) / N);
	}
}