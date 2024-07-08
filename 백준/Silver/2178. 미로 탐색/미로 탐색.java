import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static boolean[][] map;

	static Point[] directions = {new Point(1, 0), new Point(0, 1), new Point(-1, 0), new Point(0, -1)};

	public static void main(String[] args) throws IOException {
		initialize();
		System.out.println(dfs());
	}

	static void initialize() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());

		map = new boolean[N][M];
		for (int n = 0; n < N; n++) {
			String line = input.readLine();
			for (int m = 0; m < M; m++) {
				map[n][m] = line.charAt(m) == '1';
			}
		}
	}

	static int dfs() {
		Queue<Point> queue = new LinkedList<>();
		int[][] distance = new int[N][M];
		queue.add(new Point(0, 0));
		distance[0][0] = 1;

		while (!queue.isEmpty()) {
			Point current = queue.poll();
			if (current.x == N - 1 && current.y == M - 1) {
				return distance[current.x][current.y];
			}
			for (Point dir : directions) {
				int nx = current.x + dir.x;
				int ny = current.y + dir.y;
				if (isIn(nx, ny) && map[nx][ny] && distance[nx][ny] == 0) {
					distance[nx][ny] = distance[current.x][current.y] + 1;
					queue.add(new Point(nx, ny));
				}
			}
		}

		return 0;
	}

	static boolean isIn(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < M;
	}
}