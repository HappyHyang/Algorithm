import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens = null;

	static int N, min, max;

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(input.readLine());
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;

		tokens = new StringTokenizer(input.readLine());
		for (int n = 0; n < N; n++) {
			int num = Integer.parseInt(tokens.nextToken());
			if (min > num) {
				min = num;
			}
			if (max < num) {
				max = num;
			}
		}

		System.out.println(min + " " + max);
	}
}