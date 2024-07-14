import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();

	static int M, N, x, y;

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(input.readLine());
		while (T-- > 0) {
			initialize();
			output.append(solution()).append('\n');
		}
		System.out.print(output);
	}

	static void initialize() throws IOException {
		StringTokenizer tokens = new StringTokenizer(input.readLine());
		M = Integer.parseInt(tokens.nextToken());
		N = Integer.parseInt(tokens.nextToken());
		x = Integer.parseInt(tokens.nextToken()) - 1;
		y = Integer.parseInt(tokens.nextToken()) - 1;
	}

	static int solution() {
		for (int i = x; i < M * N; i += M) {
			if (i % N == y) {
				return i + 1;
			}
		}
		return -1;
	}
}