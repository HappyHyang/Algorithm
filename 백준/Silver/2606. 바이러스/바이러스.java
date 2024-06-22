import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens = null;

	static boolean[][] graph;
	static boolean[] visited;
	static int cntPC;

	public static void main(String[] args) throws IOException {
		cntPC = Integer.parseInt(input.readLine());
		int cntPair = Integer.parseInt(input.readLine());

		graph = new boolean[cntPC + 1][cntPC + 1];
		visited = new boolean[cntPC + 1];

		for (int i = 0; i < cntPair; i++) {
			tokens = new StringTokenizer(input.readLine());
			int x = Integer.parseInt(tokens.nextToken());
			int y = Integer.parseInt(tokens.nextToken());
			graph[x][y] = true;
			graph[y][x] = true;
		}

		System.out.println(DFS(1) - 1);
	}

	static int DFS(int node) {
		visited[node] = true;
		int count = 1;

		for (int i = 1; i <= cntPC; i++) {
			if (graph[node][i] && !visited[i]) {
				count += DFS(i);
			}
		}
		return count;
	}
}