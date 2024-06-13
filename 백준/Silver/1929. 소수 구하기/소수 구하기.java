import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();

	static boolean[] isPrime;

	public static void main(String[] args) throws IOException {
		StringTokenizer tokens = new StringTokenizer(input.readLine());
		int M = Integer.parseInt(tokens.nextToken());
		int N = Integer.parseInt(tokens.nextToken());

		isPrime = new boolean[N + 1];
		calcPrime();

		for (int i = M; i <= N; i++) {
			if (isPrime[i]) {
				output.append(i).append("\n");
			}
		}
		System.out.print(output);
	}

	static void calcPrime() {
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;

		for (int i = 2; i <= Math.sqrt(isPrime.length); i++) {
			if (isPrime[i]) {
				for (int j = i * i; j <= isPrime.length - 1; j += i) {
					isPrime[j] = false;
				}
			}
		}
	}
}