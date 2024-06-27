import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(input.readLine());
		int[] steps = new int[N];
		for (int i = 0; i < N; i++) {
			steps[i] = Integer.parseInt(input.readLine());
		}

		if (N == 1) {
			System.out.println(steps[0]);
			return;
		}

		int[] scores = new int[N];
		scores[0] = steps[0];
		scores[1] = Math.max(steps[1], steps[0] + steps[1]);
		if (N > 2) {
			scores[2] = Math.max(steps[0] + steps[2], steps[1] + steps[2]);
		}
		for (int i = 3; i < N; i++) {
			scores[i] = Math.max(scores[i - 2] + steps[i], scores[i - 3] + steps[i - 1] + steps[i]);
		}

		System.out.println(scores[N - 1]);
	}
}