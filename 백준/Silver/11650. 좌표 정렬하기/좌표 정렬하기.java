import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Point {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens = null;

	static int N;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());
		Point[] points = new Point[N];
		for (int n = 0; n < N; n++) {
			tokens = new StringTokenizer(input.readLine());
			points[n] = new Point(Integer.parseInt(tokens.nextToken()), Integer.parseInt(tokens.nextToken()));
		}

		Arrays.sort(points, (o1, o2) -> {
			if (o1.x == o2.x) {
				return Integer.compare(o1.y, o2.y);
			} else {
				return Integer.compare(o1.x, o2.x);
			}
		});

		for (Point point : points) {
			output.append(point.x + " " + point.y).append("\n");
		}

		System.out.print(output);
	}
}