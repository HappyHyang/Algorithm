import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int M, N; // 가로, 세로
	static int[][] tomatoes; // 토마토들의 정보

	static Queue<Point> ripeTomatoes; // 익은 토마토
	static int unripeTomatoesCnt; // 익지 않은 토마토의 수

	public static void main(String[] args) throws Exception {
		initialize();
		System.out.println(solution());
	}

	static void initialize() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(input.readLine());
		M = Integer.parseInt(tokens.nextToken()); // 가로
		N = Integer.parseInt(tokens.nextToken()); // 세로
		tomatoes = new int[N][M];
		ripeTomatoes = new LinkedList<>();
		unripeTomatoesCnt = 0;
		for (int n = 0; n < N; n++) {
			tokens = new StringTokenizer(input.readLine());
			for (int m = 0; m < M; m++) {
				tomatoes[n][m] = Integer.parseInt(tokens.nextToken());
				if (tomatoes[n][m] == 1) {
					ripeTomatoes.add(new Point(m, n));
				} else if (tomatoes[n][m] == 0) {
					unripeTomatoesCnt++;
				}
			}
		}
	}

	static int solution() {
		if (unripeTomatoesCnt == 0) {
			return 0;
		}
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		int days = -1;
		while (!ripeTomatoes.isEmpty()) {
			int size = ripeTomatoes.size();
			for (int i = 0; i < size; i++) {
				Point current = ripeTomatoes.poll();
				for (int d = 0; d < 4; d++) {
					int nx = current.x + dx[d];
					int ny = current.y + dy[d];
					if (isIn(nx, ny) && tomatoes[ny][nx] == 0) {
						tomatoes[ny][nx] = 1;
						ripeTomatoes.add(new Point(nx, ny));
						unripeTomatoesCnt--;
					}
				}
			}
			days++;
		}
		return unripeTomatoesCnt == 0 ? days : -1;
	}

	static boolean isIn(int x, int y) {
		return (0 <= x && x < M) && (0 <= y && y < N);
	}
}