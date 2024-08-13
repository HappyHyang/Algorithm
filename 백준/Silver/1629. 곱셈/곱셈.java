import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int A, B, C;

	public static void main(String[] args) throws IOException {
		initialize();
		System.out.println(solution(A, B, C));
	}

	static void initialize() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(input.readLine());
		A = Integer.parseInt(tokenizer.nextToken());
		B = Integer.parseInt(tokenizer.nextToken());
		C = Integer.parseInt(tokenizer.nextToken());
	}

	static long solution(int base, int exp, int mod) {
		if (exp == 0)
			return 1;
		long half = solution(base, exp / 2, mod);
		long halfSquared = (half * half) % mod;
		if (exp % 2 == 0) {
			return halfSquared;
		} else {
			return (halfSquared * base) % mod;
		}
	}
}