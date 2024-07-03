import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M; // 캠퍼스의 크기 NxM
	static char map[][]; // 캠퍼스 정보

	static Point doyeon; // 도연의 위치
	static Point[] dir = {new Point(1, 0), new Point(0, 1), new Point(-1, 0), new Point(0, -1)};

	public static void main(String[] args) throws IOException {
		initialize();
		System.out.println(solution());
	}

	static void initialize() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());

		map = new char[N][M];
		for (int n = 0; n < N; n++) {
			map[n] = input.readLine().toCharArray();
			for (int m = 0; m < M; m++) {
				if (map[n][m] == 'I') {
					doyeon = new Point(n, m);
				}
			}
		}
	}

	static String solution() {
		Queue<Point> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		queue.add(doyeon);
		visited[doyeon.x][doyeon.y] = true;

		int cnt = 0;
		while (!queue.isEmpty()) {
			Point current = queue.poll();
			for (Point d : dir) {
				int nx = current.x + d.x;
				int ny = current.y + d.y;
				if (isIn(nx, ny) && !visited[nx][ny] && map[nx][ny] != 'X') {
					visited[nx][ny] = true;
					if (map[nx][ny] == 'P') {
						cnt++;
					}
					queue.add(new Point(nx, ny));
				}
			}
		}

		return cnt != 0 ? Integer.toString(cnt) : "TT";
	}

	static boolean isIn(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < M;
	}
}