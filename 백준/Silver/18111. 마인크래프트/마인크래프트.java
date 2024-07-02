import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder output = new StringBuilder();

	static int N, M, B;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		initialize();
		solution();
		System.out.println(output);
	}

	static void initialize() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		B = Integer.parseInt(tokens.nextToken());

		map = new int[N][M];
		for (int n = 0; n < N; n++) {
			tokens = new StringTokenizer(input.readLine());
			for (int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(tokens.nextToken());
			}
		}
	}

	static void solution() {
		int minTime = Integer.MAX_VALUE;
		int bestHeight = 0;

		for (int targetHeight = 0; targetHeight <= 256; targetHeight++) {
			int time = 0;
			int inventory = B;

			for (int n = 0; n < N; n++) {
				for (int m = 0; m < M; m++) {
					int diff = map[n][m] - targetHeight;

					if (diff > 0) {
						time += diff * 2;
						inventory += diff;
					} else if (diff < 0) {
						time += -diff;
						inventory += diff;
					}
				}
			}
			
			if (inventory >= 0 && time <= minTime) {
				if (time < minTime || targetHeight > bestHeight) {
					minTime = time;
					bestHeight = targetHeight;
				}
			}
		}

		output.append(minTime).append(" ").append(bestHeight);
	}
}