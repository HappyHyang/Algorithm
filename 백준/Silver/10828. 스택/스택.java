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
		Deque<Integer> stack = new ArrayDeque<>();
		for (int n = 0; n < N; n++) {
			tokens = new StringTokenizer(input.readLine());
			switch (tokens.nextToken()) {
				case "push":
					stack.push(Integer.parseInt(tokens.nextToken()));
					break;
				case "pop":
					output.append(stack.isEmpty() ? -1 : stack.pop()).append("\n");
					break;
				case "size":
					output.append(stack.size() + "\n");
					break;
				case "empty":
					output.append(stack.isEmpty() ? 1 : 0).append("\n");
					break;
				case "top":
					output.append(stack.isEmpty() ? -1 : stack.peek()).append("\n");
					break;
			}
		}
		System.out.print(output);
	}
}