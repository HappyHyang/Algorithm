import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] map;
	static Point goal;

	static int[][] distance;
	static Point[] directions = {new Point(1, 0), new Point(0, 1), new Point(-1, 0), new Point(0, -1)};

	public static void main(String[] args) throws IOException {
		initialize();
		solution();
		printDistance();
	}

	static void initialize() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());

		distance = new int[N][M];

		map = new int[N][M];
		for (int row = 0; row < N; row++) {
			tokens = new StringTokenizer(input.readLine());
			for (int col = 0; col < M; col++) {
				map[row][col] = Integer.parseInt(tokens.nextToken());

				if (map[row][col] != 0) {
					distance[row][col] = -1;
					if (map[row][col] == 2) {
						goal = new Point(row, col);
					}
				}
			}
		}
	}

	static void printDistance() {
		StringBuilder output = new StringBuilder();
		for (int[] row : distance) {
			for (int i : row) {
				output.append(i).append(" ");
			}
			output.append("\n");
		}
		System.out.println(output);
	}

	static void solution() {
		boolean[][] isVisited = new boolean[N][M];
		Queue<Point> queue = new LinkedList<>();
		queue.add(goal);
		isVisited[goal.x][goal.y] = true;
		distance[goal.x][goal.y] = 0;

		while (!queue.isEmpty()) {
			Point current = queue.poll();
			for (Point direction : directions) {
				Point next = new Point(current.x + direction.x, current.y + direction.y);
				if (isIn(next) && !isVisited[next.x][next.y] && map[next.x][next.y] == 1) {
					isVisited[next.x][next.y] = true;
					distance[next.x][next.y] = distance[current.x][current.y] + 1;
					queue.add(next);
				}
			}
		}
	}

	static boolean isIn(Point point) {
		return 0 <= point.x && point.x < N && 0 <= point.y && point.y < M;
	}
}