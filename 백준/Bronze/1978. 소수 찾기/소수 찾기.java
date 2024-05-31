import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens = null;

	static int N, answer;

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(input.readLine());
		answer = 0;

		tokens = new StringTokenizer(input.readLine());
		for (int n = 0; n < N; n++) {
			if (isPrimeNum(Integer.parseInt(tokens.nextToken()))) {
				answer++;
			}
		}

		System.out.println(answer);
	}

	static boolean isPrimeNum(int num) {
		if (num < 2) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}