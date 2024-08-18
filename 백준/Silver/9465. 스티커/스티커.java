import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();

	static int n;
	static int[][] stickers;

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(input.readLine());
		while (T-- > 0) {
			initialize();
			output.append(selectSticker()).append('\n');
		}
		System.out.print(output);
	}

	static void initialize() throws IOException {
		n = Integer.parseInt(input.readLine());

		stickers = new int[2][n];
		for (int row = 0; row < 2; row++) {
			stickers[row] = Arrays.stream(input.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
	}

	static int selectSticker() {
		int[][] scores = new int[3][n];
		scores[0][0] = stickers[0][0];
		scores[1][0] = stickers[1][0];
		scores[2][0] = 0;

		for (int i = 1; i < n; i++) {
			scores[0][i] = stickers[0][i] + Math.max(scores[1][i - 1], scores[2][i - 1]);
			scores[1][i] = stickers[1][i] + Math.max(scores[0][i - 1], scores[2][i - 1]);
			scores[2][i] = Math.max(scores[0][i - 1], scores[1][i - 1]);
		}

		return Math.max(scores[0][n - 1], Math.max(scores[1][n - 1], scores[2][n - 1]));
	}
}