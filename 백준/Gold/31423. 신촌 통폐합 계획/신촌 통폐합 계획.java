import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(input.readLine());

		String[] names = new String[N + 1];
		int[] next = new int[N + 1];
		int[] tail = new int[N + 1];
		for (int n = 1; n <= N; n++) {
			names[n] = input.readLine();
			next[n] = n;
			tail[n] = n;
		}

		int k = 0;
		for (int n = 0; n < N - 1; n++) {
			StringTokenizer tokenizer = new StringTokenizer(input.readLine());
			int i = Integer.parseInt(tokenizer.nextToken());
			int j = Integer.parseInt(tokenizer.nextToken());
			next[tail[i]] = j;
			tail[i] = tail[j];
			k = i;
		}

		StringBuilder output = new StringBuilder();
		for (int i = 0; i < N; i++) {
			output.append(names[k]);
			k = next[k];
		}
		System.out.println(output);
	}
}