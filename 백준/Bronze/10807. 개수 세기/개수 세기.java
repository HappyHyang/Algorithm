import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(input.readLine());

		StringTokenizer tokenizer = new StringTokenizer(input.readLine());
		int[] numbers = new int[N];
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(tokenizer.nextToken());
		}

		int v = Integer.parseInt(input.readLine());

		int answer = 0;
		for (int number : numbers) {
			if (number == v)
				answer++;
		}

		System.out.println(answer);
	}
}