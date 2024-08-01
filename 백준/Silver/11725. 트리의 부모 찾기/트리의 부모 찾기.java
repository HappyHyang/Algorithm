import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static ArrayList<Integer>[] nodes;

	static int[] parent;

	public static void main(String[] args) throws IOException {
		initialzie();
		findParent();
		printParentNode();
	}

	static void initialzie() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(input.readLine());
		nodes = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			nodes[i] = new ArrayList<>();
		}
		for (int i = 1; i < N; i++) {
			StringTokenizer tokens = new StringTokenizer(input.readLine());
			int u = Integer.parseInt(tokens.nextToken());
			int v = Integer.parseInt(tokens.nextToken());
			nodes[u].add(v);
			nodes[v].add(u);
		}
		parent = new int[N + 1];
	}

	static void findParent() {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(1);
		while (!queue.isEmpty()) {
			int current = queue.poll();
			for (int next : nodes[current]) {
				if (next != parent[current]) {
					parent[next] = current;
					queue.offer(next);
				}
			}
		}
	}

	static void printParentNode() {
		StringBuilder output = new StringBuilder();
		for (int i = 2; i <= N; i++) {
			output.append(parent[i]).append('\n');
		}
		System.out.print(output);
	}
}