import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int A, B;

	public static void main(String[] args) throws IOException {
		initialize();
		System.out.println(solution());
	}

	static void initialize() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(input.readLine());
		A = Integer.parseInt(tokenizer.nextToken());
		B = Integer.parseInt(tokenizer.nextToken());
	}

	static int solution() {
		Queue<long[]> queue = new LinkedList<>();
		queue.offer(new long[] {A, 1});

		while (!queue.isEmpty()) {
			long[] current = queue.poll();
			long num = current[0];
			long count = current[1];

			if (num == B) {
				return (int)count;
			}

			long nextNum = num * 2;
			if (nextNum <= B) {
				queue.offer(new long[] {nextNum, count + 1});
			}

			nextNum = num * 10 + 1;
			if (nextNum <= B) {
				queue.offer(new long[] {nextNum, count + 1});
			}
		}

		return -1;
	}
}