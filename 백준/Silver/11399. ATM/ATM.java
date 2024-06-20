import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(input.readLine());

		StringTokenizer tokens = new StringTokenizer(input.readLine());
		int[] times = new int[N];
		for (int n = 0; n < N; n++) {
			times[n] = Integer.parseInt(tokens.nextToken());
		}

		Arrays.sort(times);
		int answer = 0;
		for (int i = 0; i < N; i++) {
			answer += times[i] * (N - i);
		}
		System.out.println(answer);
	}
}