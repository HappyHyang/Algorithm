import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(input.readLine());

		Stack<Integer> stack = new Stack<>();
		int current = 1;
		for (int n = 0; n < N; n++) {
			int num = Integer.parseInt(input.readLine());
			while (current <= num) {
				stack.push(current);
				output.append("+\n");
				current++;
			}

			if (stack.peek() == num) {
				stack.pop();
				output.append("-\n");
			} else {
				output.setLength(0);
				output.append("NO");
				break;
			}
		}
		System.out.println(output);
	}
}