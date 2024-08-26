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
	static int v1, v2;

	public static void main(String[] args) throws IOException {
		initialize();
		System.out.println(solution());
	}

	static void initialize() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(input.readLine());
		int node = Integer.parseInt(tokenizer.nextToken());
		int edge = Integer.parseInt(tokenizer.nextToken());

		for (int i = 0; i <= node; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < edge; i++) {
			tokenizer = new StringTokenizer(input.readLine());
			int a = Integer.parseInt(tokenizer.nextToken());
			int b = Integer.parseInt(tokenizer.nextToken());
			int c = Integer.parseInt(tokenizer.nextToken());

			graph.get(a).add(new Node(b, c));
			graph.get(b).add(new Node(a, c));
		}

		tokenizer = new StringTokenizer(input.readLine());
		v1 = Integer.parseInt(tokenizer.nextToken());
		v2 = Integer.parseInt(tokenizer.nextToken());
	}

	static int solution() {
		int[] distStart = dijkstra(1);
		int[] distV1 = dijkstra(v1);
		int[] distV2 = dijkstra(v2);

		if (distStart[v1] == Integer.MAX_VALUE || distStart[v2] == Integer.MAX_VALUE
			|| distV1[v2] == Integer.MAX_VALUE || distV2[v1] == Integer.MAX_VALUE
			|| distV1[graph.size() - 1] == Integer.MAX_VALUE || distV2[graph.size() - 1] == Integer.MAX_VALUE) {
			return -1;
		}

		// 1번 -> v1 -> v2 -> N번
		int path1 = distStart[v1] + distV1[v2] + distV2[graph.size() - 1];
		// 1번 -> v2 -> v1 -> N번
		int path2 = distStart[v2] + distV2[v1] + distV1[graph.size() - 1];

		return Math.min(path1, path2);
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