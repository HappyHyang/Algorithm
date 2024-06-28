import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	static int blue = 0;
	static int white = 0;
	static boolean[][] paper;

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(input.readLine());

		paper = new boolean[N][N];
		for (int x = 0; x < N; x++) {
			StringTokenizer tokens = new StringTokenizer(input.readLine());
			for (int y = 0; y < N; y++) {
				paper[x][y] = "1".equals(tokens.nextToken());
			}
		}

		divide(0, 0, N);

		System.out.print(white + "\n" + blue);
	}

	static void divide(int x, int y, int size) {
		if (checkColor(x, y, size)) {
			if (paper[x][y]) {
				blue++;
			} else {
				white++;
			}
			return;
		}

		int newSize = size / 2;
		divide(x, y, newSize);
		divide(x, y + newSize, newSize);
		divide(x + newSize, y, newSize);
		divide(x + newSize, y + newSize, newSize);
	}

	static boolean checkColor(int x, int y, int size) {
		boolean color = paper[x][y];
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (paper[i][j] != color) {
					return false;
				}
			}
		}
		return true;
	}
}