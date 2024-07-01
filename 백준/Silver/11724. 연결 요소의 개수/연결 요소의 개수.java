import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static boolean[][] graph;

	static boolean[] visited;
	static int answer;

	public static void main(String[] args) throws IOException {
		initialize();
		solution();
		System.out.println(answer);
	}

	static void initialize() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());

		graph = new boolean[N + 1][N + 1]; // 1 base
		for (int m = 0; m < M; m++) {
			tokens = new StringTokenizer(input.readLine());
			int x = Integer.parseInt(tokens.nextToken());
			int y = Integer.parseInt(tokens.nextToken());
			graph[x][y] = true;
			graph[y][x] = true;
		}
	}

	static void solution() {
		visited = new boolean[N + 1];
		answer = 0;
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				dfs(i);
				answer++;
			}
		}
	}

	static void dfs(int v) {
		visited[v] = true;
		for (int next = 1; next <= N; next++) {
			if (graph[v][next] && !visited[next]) {
				dfs(next);
			}
		}
	}
}