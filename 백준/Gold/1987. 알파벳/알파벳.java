import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int R, C;
	static char[][] board;

	static boolean[] visited = new boolean[26];
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	static int maxLength = 0;

	public static void main(String[] args) throws IOException {
		initialize();
		dfs(0, 0, 1);
		System.out.println(maxLength);
	}

	static void initialize() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(input.readLine());

		R = Integer.parseInt(tokenizer.nextToken());
		C = Integer.parseInt(tokenizer.nextToken());

		board = new char[R][C];
		for (int row = 0; row < R; row++) {
			board[row] = input.readLine().toCharArray();
		}
	}

	static void dfs(int row, int col, int depth) {
		visited[board[row][col] - 'A'] = true;

		if (depth > maxLength) {
			maxLength = depth;
		}

		for (int d = 0; d < 4; d++) {
			int nr = row + dx[d];
			int nc = col + dy[d];
			if (isIn(nr, nc) && !visited[board[nr][nc] - 'A']) {
				dfs(nr, nc, depth + 1);
			}
		}
		
		visited[board[row][col] - 'A'] = false;

	}

	static boolean isIn(int row, int col) {
		return (0 <= row && row < R) && (0 <= col && col < C);
	}
}