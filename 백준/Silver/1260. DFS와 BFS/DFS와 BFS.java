import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();

	static int N, M, V;
	static List<List<Integer>> graph;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		init();

		// DFS
		dfs(V);
		output.append("\n");
		Arrays.fill(visited, false);
		// BFS
		bfs(V);

		System.out.println(output);
	}

	static void init() throws IOException {
		StringTokenizer tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		V = Integer.parseInt(tokens.nextToken());

		graph = new ArrayList<>();
		visited = new boolean[N + 1];
		for (int n = 0; n <= N; n++) {
			graph.add(new ArrayList<>());
		}

		for (int m = 0; m < M; m++) {
			tokens = new StringTokenizer(input.readLine());
			int u = Integer.parseInt(tokens.nextToken());
			int v = Integer.parseInt(tokens.nextToken());
			graph.get(u).add(v);
			graph.get(v).add(u);
		}

		for (List<Integer> adjacencyList : graph) {
			Collections.sort(adjacencyList);
		}
	}

	static void dfs(int node) {
		visited[node] = true;
		output.append(node + " ");
		for (int next : graph.get(node)) {
			if (!visited[next]) {
				dfs(next);
			}
		}
	}

	static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		visited[start] = true;
		queue.add(start);

		while (!queue.isEmpty()) {
			int cur = queue.poll();
			output.append(cur + " ");
			for (int next : graph.get(cur)) {
				if (!visited[next]) {
					visited[next] = true;
					queue.add(next);
				}
			}
		}
	}
}