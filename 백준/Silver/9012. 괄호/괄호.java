import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(input.readLine());

		for (int n = 0; n < N; n++) {
			if (isBalanced(input.readLine())) {
				output.append("YES\n");
			} else {
				output.append("NO\n");
			}
		}
		System.out.print(output);
	}

	static boolean isBalanced(String str) {
		Stack<Character> stack = new Stack<>();
		for (char c : str.toCharArray()) {
			switch (c) {
				case '(':
					stack.push(c);
					break;
				case ')':
					if (stack.isEmpty() || stack.pop() != '(') {
						return false;
					}
					break;
			}
		}
		return stack.isEmpty();
	}
}