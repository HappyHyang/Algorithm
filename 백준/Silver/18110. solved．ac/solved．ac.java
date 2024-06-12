import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(input.readLine());

		if (N == 0) {
			System.out.println(0);
			return;
		}

		int[] levels = new int[N];

		for (int n = 0; n < N; n++) {
			levels[n] = Integer.parseInt(input.readLine());
		}
		Arrays.sort(levels);

		int exception = Math.round(N * 0.15f);
		int sum = 0;
		for (int i = exception; i < N - exception; i++) {
			sum += levels[i];
		}

		int cnt = N - (2 * exception);
		int avg = cnt > 0 ? Math.round((float)sum / cnt) : 0;
		System.out.println(avg);
	}
}