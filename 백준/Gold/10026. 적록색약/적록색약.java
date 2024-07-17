import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N;
	static char[][] paint;

	static boolean[][] visited;
	static Point[] directions = {new Point(1, 0), new Point(0, 1), new Point(-1, 0), new Point(0, -1)};

	public static void main(String[] args) throws IOException {
		initialize();
		System.out.println(countRegions(false) + " " + countRegions(true));
	}

	static void initialize() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(input.readLine());

		paint = new char[N][N];
		for (int n = 0; n < N; n++) {
			paint[n] = input.readLine().toCharArray();
		}
	}

	static int countRegions(boolean isColorBlind) {
		visited = new boolean[N][N];
		int area = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					bfs(new Point(i, j), paint[i][j], isColorBlind);
					area++;
				}
			}
		}
		return area;
	}

	static void bfs(Point start, char color, boolean isColorBlind) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(start);
		visited[start.x][start.y] = true;

		while (!queue.isEmpty()) {
			Point current = queue.poll();
			for (Point direction : directions) {
				Point next = new Point(current.x + direction.x, current.y + direction.y);
				if (isIn(next) && !visited[next.x][next.y] && isSameColor(paint[current.x][current.y],
					paint[next.x][next.y], isColorBlind)) {
					visited[next.x][next.y] = true;
					queue.add(next);
				}
			}
		}
	}

	static boolean isIn(Point point) {
		return 0 <= point.x && point.x < N && 0 <= point.y && point.y < N;
	}

	static boolean isSameColor(char c1, char c2, boolean isColorBlind) {
		if (isColorBlind) {
			if ((c1 == 'R' || c1 == 'G') && (c2 == 'R' || c2 == 'G'))
				return true;
			return c1 == c2;
		}
		return c1 == c2;
	}
}