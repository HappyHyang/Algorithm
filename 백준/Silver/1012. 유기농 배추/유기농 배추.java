import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens = null;

	static int M, N;
	static boolean[][] cabbageField, visited;

	static int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(input.readLine());
		for (int t = 0; t < T; t++) {
			// init
			tokens = new StringTokenizer(input.readLine());
			M = Integer.parseInt(tokens.nextToken());
			N = Integer.parseInt(tokens.nextToken());
			int K = Integer.parseInt(tokens.nextToken());
			cabbageField = new boolean[M][N];
			for (int k = 0; k < K; k++) {
				tokens = new StringTokenizer(input.readLine());
				int x = Integer.parseInt(tokens.nextToken());
				int y = Integer.parseInt(tokens.nextToken());
				cabbageField[x][y] = true;
			}

			// solution
			int cnt = 0;
			visited = new boolean[M][N];
			for (int x = 0; x < M; x++) {
				for (int y = 0; y < N; y++) {
					if (cabbageField[x][y] && !visited[x][y]) {
						dfs(x, y);
						cnt++;
					}
				}
			}
			output.append(cnt + "\n");
		}
		System.out.print(output);
	}

	static void dfs(int x, int y) {
		visited[x][y] = true;
		for (int[] dir : directions) {
			int nx = x + dir[0];
			int ny = y + dir[1];
			if (isIn(nx, ny) && cabbageField[nx][ny] && !visited[nx][ny]) {
				dfs(nx, ny);
			}
		}
	}

	static boolean isIn(int x, int y) {
		return 0 <= x && x < M && 0 <= y && y < N;
	}
}