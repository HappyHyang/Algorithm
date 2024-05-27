import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	static int N = 9;

	public static void main(String[] args) throws Exception {
		int max = Integer.MIN_VALUE;
		int index = 0;

		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(input.readLine());
			if (n > max) {
				max = n;
				index = i;
			}
		}
		System.out.printf("%d%n%d", max, index + 1);
	}
}