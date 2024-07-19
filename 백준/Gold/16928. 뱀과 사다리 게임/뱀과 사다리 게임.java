import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] board = new int[101];

	public static void main(String[] args) throws Exception {
		initialize();
		System.out.println(solution());
	}

	static void initialize() throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(input.readLine());
		int N = Integer.parseInt(tokens.nextToken());
		int M = Integer.parseInt(tokens.nextToken());
		for (int i = 1; i <= 100; i++) {
			board[i] = i;
		}
		for (int i = 0; i < N + M; i++) {
			tokens = new StringTokenizer(input.readLine());
			int from = Integer.parseInt(tokens.nextToken());
			int to = Integer.parseInt(tokens.nextToken());
			board[from] = to;
		}
	}

	static int solution() {
		int[] diceCnt = new int[101];
		Arrays.fill(diceCnt, Integer.MAX_VALUE);
		diceCnt[1] = 0;

		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		while (!queue.isEmpty()) {
			int current = queue.poll();
			for (int dice = 1; dice <= 6; dice++) {
				int next = current + dice;
				if (next <= 100) {
					int move = board[next];
					if (diceCnt[move] > diceCnt[current] + 1) {
						diceCnt[move] = diceCnt[current] + 1;
						queue.add(move);
					}
				}
			}
		}
		return diceCnt[100];
	}
}