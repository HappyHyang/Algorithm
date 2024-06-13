import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();

	static class Doc {
		public int idx;
		public int importance;

		public Doc(int idx, int importance) {
			this.idx = idx;
			this.importance = importance;
		}
	}

	public static void main(String[] args) throws IOException {
		int TC = Integer.parseInt(input.readLine());

		for (int tc = 0; tc < TC; tc++) {
			StringTokenizer tokens = new StringTokenizer(input.readLine());
			int N = Integer.parseInt(tokens.nextToken());
			int idx = Integer.parseInt(tokens.nextToken());

			int[] importanceCnt = new int[10]; // 1 base

			tokens = new StringTokenizer(input.readLine());
			Queue<Doc> printer = new LinkedList<>();
			for (int n = 0; n < N; n++) {
				int importance = Integer.parseInt(tokens.nextToken());
				importanceCnt[importance]++;
				printer.offer(new Doc(n, importance));
			}

			int printOrder = 0;
			while (!printer.isEmpty()) {
				for (int i = 9; i > 0; i--) {
					while (importanceCnt[i] > 0) {
						Doc current = printer.poll();
						if (current.importance == i) {
							printOrder++;
							importanceCnt[i]--;
							if (current.idx == idx) {
								output.append(printOrder).append("\n");
								break;
							}
						} else {
							printer.offer(current);
						}
					}
				}
			}
		}
		System.out.print(output);
	}
}