import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int hour, min;

	public static void main(String[] args) throws IOException {
		initialize();
		System.out.println(minEffortTime());
	}

	static void initialize() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(input.readLine(), ":");
		hour = Integer.parseInt(tokenizer.nextToken());
		min = Integer.parseInt(tokenizer.nextToken());
	}

	static String minEffortTime() {
		int bestHour = 0;
		int bestMin = 0;
		int minEffort = Integer.MAX_VALUE;
		for (int h = hour; h < 100; h += 24) {
			for (int m = min; m < 100; m += 60) {
				int[] nums = {h / 10, h % 10, m / 10, m % 10};
				int effort = calcTotalEffort(nums);
				if (effort < minEffort) {
					minEffort = effort;
					bestHour = h;
					bestMin = m;
				}
			}
		}
		return String.format("%02d:%02d", bestHour, bestMin);
	}

	static int calcTotalEffort(int[] nums) {
		int total = 0;
		for (int i = 0; i < 3; i++) {
			total += calcEffort(nums[i], nums[i + 1]);
		}
		return total;
	}

	static int calcEffort(int prev, int next) {
		int[][] pos = {{3, 1}, {0, 0}, {0, 1},
			{0, 2}, {1, 0}, {1, 1},
			{1, 2}, {2, 0}, {2, 1},
			{2, 2}};
		return Math.abs(pos[prev][0] - pos[next][0]) + Math.abs(pos[prev][1] - pos[next][1]);
	}
}