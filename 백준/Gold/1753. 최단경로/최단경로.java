import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static List<List<Node>> graph = new ArrayList<>();
	static int start;

	public static void main(String[] args) throws IOException {
		initialize();
		printPath(dijkstra(start));
	}

	static void initialize() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(input.readLine());
		int vertex = Integer.parseInt(tokenizer.nextToken());
		int edge = Integer.parseInt(tokenizer.nextToken());

		start = Integer.parseInt(input.readLine());

		for (int i = 0; i <= vertex; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < edge; i++) {
			tokenizer = new StringTokenizer(input.readLine());
			int u = Integer.parseInt(tokenizer.nextToken());
			int v = Integer.parseInt(tokenizer.nextToken());
			int w = Integer.parseInt(tokenizer.nextToken());

			graph.get(u).add(new Node(v, w));
		}
	}

	static void printPath(int[] dist) {
		StringBuilder output = new StringBuilder();
		for (int i = 1; i < dist.length; i++) {
			output.append(dist[i] != Integer.MAX_VALUE ? dist[i] : "INF");
			output.append('\n');
		}
		System.out.print(output);
	}

	static int[] dijkstra(int start) {
		int N = graph.size();
		boolean[] visited = new boolean[N];
		int[] dist = new int[N];
		Arrays.fill(dist, Integer.MAX_VALUE);

		PriorityQueue<Node> pq = new PriorityQueue<>();
		dist[start] = 0;
		pq.offer(new Node(start, 0));
		while (!pq.isEmpty()) {
			Node current = pq.poll();
			int currentNode = current.vertex;

			if (visited[currentNode]) {
				continue;
			}
			visited[currentNode] = true;

			for (Node node : graph.get(currentNode)) {
				int nextNode = node.vertex;
				int distance = dist[currentNode] + node.weight;

				if (distance < dist[nextNode]) {
					dist[nextNode] = distance;
					pq.offer(new Node(nextNode, distance));
				}
			}
		}
		return dist;
	}

	static class Node implements Comparable<Node> {
		int vertex;
		int weight;

		Node(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
}