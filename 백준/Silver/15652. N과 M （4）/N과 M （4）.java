import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static StringBuilder output = new StringBuilder();
	static int[] selected;

	public static void main(String[] args) throws IOException {
		initialize();
		solution(1, 0);
		System.out.print(output);

	}

	static void initialize() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		selected = new int[M];
	}

	static void solution(int start, int cnt) {
		if (cnt == M) {
			for (int i : selected) {
				output.append(i).append(' ');
			}
			output.append('\n');
			return;
		}

		for (int i = start; i <= N; i++) {
			selected[cnt] = i;
			solution(i, cnt + 1);
		}
	}
}