import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static boolean[][] rooms;

	static int count;

	public static void main(String[] args) throws IOException {
		initialize();
		movePipe(0, 1, 0);
		System.out.println(count);
	}

	static void initialize() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(input.readLine());

		rooms = new boolean[N][N];
		for (int row = 0; row < N; row++) {
			StringTokenizer tokenizer = new StringTokenizer(input.readLine());
			for (int col = 0; col < N; col++) {
				rooms[row][col] = tokenizer.nextToken().equals("0");
			}
		}

		count = 0;
	}

	static void movePipe(int r, int c, int dir) {
		if (r == N - 1 && c == N - 1) {
			count++;
			return;
		}

		if (dir == 0 || dir == 2) {
			if (isIn(r, c + 1) && rooms[r][c + 1]) {
				movePipe(r, c + 1, 0);
			}
		}
		if (dir == 1 || dir == 2) {
			if (isIn(r + 1, c) && rooms[r + 1][c]) {
				movePipe(r + 1, c, 1);
			}
		}
		if (isIn(r + 1, c + 1) && rooms[r + 1][c + 1] && rooms[r][c + 1] && rooms[r + 1][c]) {
			movePipe(r + 1, c + 1, 2);
		}
	}

	static boolean isIn(int r, int c) {
		return (0 <= r && r < N) && (0 <= c && c < N);
	}
}