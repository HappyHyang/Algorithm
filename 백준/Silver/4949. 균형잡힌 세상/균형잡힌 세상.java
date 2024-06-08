import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();

	public static void main(String[] args) throws IOException {
		String str;

		while (!(str = input.readLine()).equals(".")) {
			if (isBalanced(str)) {
				output.append("yes\n");
			} else {
				output.append("no\n");
			}
		}
		System.out.print(output);
	}

	static boolean isBalanced(String str) {
		Stack<Character> stack = new Stack<>();
		for (char c : str.toCharArray()) {
			switch (c) {
				case '(':
				case '[':
					stack.push(c);
					break;
				case ')':
					if (stack.isEmpty() || stack.pop() != '(') {
						return false;
					}
					break;
				case ']':
					if (stack.isEmpty() || stack.pop() != '[') {
						return false;
					}
					break;
			}
		}
		return stack.isEmpty();
	}
}