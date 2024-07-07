import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, K;

	public static void main(String[] args) throws IOException {
		initialize();
		System.out.println(bfs());
	}

	static void initialize() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(input.readLine());

		N = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
	}

	static int bfs() {
		int[] distance = new int[Math.max(2 * K, N) + 1];
		boolean[] visited = new boolean[distance.length];

		Queue<Integer> queue = new LinkedList<>();
		queue.add(N);
		visited[N] = true;
		distance[N] = 0;

		while (!queue.isEmpty()) {
			int current = queue.poll();

			if (current == K) {
				return distance[current];
			}

			int[] next = {current - 1, current + 1, 2 * current};
			for (int n : next) {
				if (n >= 0 && n < visited.length && !visited[n]) {
					visited[n] = true;
					distance[n] = distance[current] + 1;
					queue.add(n);
				}
			}
		}

		return 0;
	}
}