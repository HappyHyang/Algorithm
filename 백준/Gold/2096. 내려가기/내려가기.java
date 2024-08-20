import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N;
	static int[][] nums;

	static int maxScore, minScore;

	public static void main(String[] args) throws IOException {
		initialize();
		calcScore();
		System.out.println(maxScore + " " + minScore);
	}

	static void initialize() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(input.readLine());

		nums = new int[N][3];
		for (int n = 0; n < N; n++) {
			nums[n] = Arrays.stream(input.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
	}

	static void calcScore() {
		int[] prevMinScores = nums[0];
		int[] prevMaxScores = nums[0];

		for (int i = 1; i < N; i++) {
			int[] currentMinScores = new int[3];
			int[] currentMaxScores = new int[3];

			currentMinScores[0] = nums[i][0] + Math.min(prevMinScores[0], prevMinScores[1]);
			currentMinScores[1] = nums[i][1] + Math.min(Math.min(prevMinScores[0], prevMinScores[1]), prevMinScores[2]);
			currentMinScores[2] = nums[i][2] + Math.min(prevMinScores[1], prevMinScores[2]);

			currentMaxScores[0] = nums[i][0] + Math.max(prevMaxScores[0], prevMaxScores[1]);
			currentMaxScores[1] = nums[i][1] + Math.max(Math.max(prevMaxScores[0], prevMaxScores[1]), prevMaxScores[2]);
			currentMaxScores[2] = nums[i][2] + Math.max(prevMaxScores[1], prevMaxScores[2]);

			prevMinScores = currentMinScores;
			prevMaxScores = currentMaxScores;
		}

		minScore = Math.min(prevMinScores[0], Math.min(prevMinScores[1], prevMinScores[2]));
		maxScore = Math.max(prevMaxScores[0], Math.max(prevMaxScores[1], prevMaxScores[2]));
	}
}