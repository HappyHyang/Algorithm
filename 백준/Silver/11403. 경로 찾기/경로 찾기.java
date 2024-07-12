import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static boolean[][] graph;

	public static void main(String[] args) throws IOException {
		initialize();
		System.out.print(solution());
	}

	static void initialize() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(input.readLine());

		graph = new boolean[N][N];
		for (int row = 0; row < N; row++) {
			StringTokenizer tokens = new StringTokenizer(input.readLine());
			for (int col = 0; col < N; col++) {
				graph[row][col] = tokens.nextToken().equals("1");
			}
		}
	}

	static String solution() {
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (graph[i][k] && graph[k][j]) {
						graph[i][j] = true;
					}
				}
			}
		}

		StringBuilder output = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				output.append(graph[i][j] ? 1 : 0).append(" ");
			}
			output.append("\n");
		}
		return output.toString();
	}
}