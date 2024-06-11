import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens = null;

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(input.readLine());
		Deque<Integer> queue = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			tokens = new StringTokenizer(input.readLine());
			switch (tokens.nextToken()) {
				case "push":
					queue.offer(Integer.parseInt(tokens.nextToken()));
					break;
				case "pop":
					output.append(queue.isEmpty() ? -1 : queue.poll()).append("\n");
					break;
				case "size":
					output.append(queue.size()).append("\n");
					break;
				case "empty":
					output.append(queue.isEmpty() ? 1 : 0).append("\n");
					break;
				case "front":
					output.append(queue.isEmpty() ? -1 : queue.peekFirst()).append("\n");
					break;
				case "back":
					output.append(queue.isEmpty() ? -1 : queue.peekLast()).append("\n");
					break;
			}
		}
		System.out.print(output);
	}
}