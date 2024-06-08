import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	static int K;

	public static void main(String[] args) throws IOException {
		K = Integer.parseInt(input.readLine());
		Stack<Integer> stack = new Stack<>();

		for (int k = 0; k < K; k++) {
			int num = Integer.parseInt(input.readLine());
			if (num == 0 && !stack.isEmpty()) {
				stack.pop();
			} else {
				stack.push(num);
			}
		}

		int sum = 0;
		for (Integer num : stack) {
			sum += num;
		}

		System.out.println(sum);
	}
}