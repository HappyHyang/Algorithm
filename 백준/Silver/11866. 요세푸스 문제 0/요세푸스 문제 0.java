import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens = null;

	static int N, K;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());

		Queue<Integer> nums = new LinkedList<>();
		for (int n = 1; n <= N; n++) {
			nums.add(n);
		}

		output.append("<");
		while (!nums.isEmpty()) {
			for (int i = 1; i < K; i++) {
				nums.add(nums.poll());
			}
			output.append(nums.poll()).append(", ");
		}
		output.delete(output.length() - 2, output.length());
		output.append(">");
		System.out.println(output);
	}
}