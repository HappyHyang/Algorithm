import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static List<int[]> problems = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		initialize();
		System.out.println(solution());
	}

	static void initialize() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(input.readLine());

		while (N-- > 0) {
			StringTokenizer tokenizer = new StringTokenizer(input.readLine());
			int deadline = Integer.parseInt(tokenizer.nextToken());
			int ramen = Integer.parseInt(tokenizer.nextToken());
			problems.add(new int[] {deadline, ramen});
		}
	}

	static int solution() {
		Collections.sort(problems, (a, b) -> a[0] - b[0]);

		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for (int[] problem : problems) {
			queue.offer(problem[1]);
			if (queue.size() > problem[0]) {
				queue.poll();
			}
		}

		int reward = 0;
		while (!queue.isEmpty()) {
			reward += queue.poll();
		}

		return reward;
	}
}