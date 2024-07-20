import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Point {
		int x, y, z;

		public Point(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

	static int M, N, H; // 가로, 세로, 높이
	static int[][][] tomatoes;

	static Queue<Point> queue;
	static int unripeTomatoesCnt;

	public static void main(String[] args) throws Exception {
		initialize();
		System.out.println(solution());
	}

	static void initialize() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(input.readLine());
		M = Integer.parseInt(tokens.nextToken());
		N = Integer.parseInt(tokens.nextToken());
		H = Integer.parseInt(tokens.nextToken());

		tomatoes = new int[M][N][H];
		queue = new LinkedList<>();
		unripeTomatoesCnt = 0;
		for (int h = 0; h < H; h++) {
			for (int n = 0; n < N; n++) {
				tokens = new StringTokenizer(input.readLine());
				for (int m = 0; m < M; m++) {
					tomatoes[m][n][h] = Integer.parseInt(tokens.nextToken());
					if (tomatoes[m][n][h] == 1) {
						queue.add(new Point(m, n, h));
					} else if (tomatoes[m][n][h] == 0) {
						unripeTomatoesCnt++;
					}
				}
			}
		}
	}

	static int solution() {
		if (unripeTomatoesCnt == 0) {
			return 0;
		}

		int days = -1;
		int[] dx = {1, -1, 0, 0, 0, 0};
		int[] dy = {0, 0, 1, -1, 0, 0};
		int[] dz = {0, 0, 0, 0, 1, -1};

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Point current = queue.poll();
				for (int d = 0; d < 6; d++) {
					int nx = current.x + dx[d];
					int ny = current.y + dy[d];
					int nz = current.z + dz[d];
					if (isIn(nx, ny, nz) && tomatoes[nx][ny][nz] == 0) {
						tomatoes[nx][ny][nz] = 1;
						queue.add(new Point(nx, ny, nz));
						unripeTomatoesCnt--;
					}
				}
			}
			days++;
		}
		return unripeTomatoesCnt == 0 ? days : -1;
	}

	static boolean isIn(int x, int y, int z) {
		return (0 <= x && x < M) && (0 <= y && y < N) && (0 <= z && z < H);
	}
}