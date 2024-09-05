import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String str = input.readLine();

		Stack<Character> stack = new Stack<>();
		int answer = 0;
		int temp = 1;

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			switch (c) {
				case '(':
					stack.push(c);
					temp *= 2;
					break;
				case '[':
					stack.push(c);
					temp *= 3;
					break;
				case ')':
					if (stack.isEmpty() || stack.peek().equals('[')) {
						System.out.println(0);
						return;
					}
					if (stack.peek().equals('(')) {
						if (str.charAt(i - 1) == '(') {
							answer += temp;
						}
						stack.pop();
					}
					temp /= 2;
					break;
				case ']':
					if (stack.isEmpty() || stack.peek().equals('(')) {
						System.out.println(0);
						return;
					}
					if (stack.peek().equals('[')) {
						if (str.charAt(i - 1) == '[') {
							answer += temp;
						}
						stack.pop();
					}
					temp /= 3;
					break;
			}
		}

		System.out.println(stack.isEmpty() ? answer : 0);
	}
}