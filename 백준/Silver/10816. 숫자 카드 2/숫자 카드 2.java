import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens = null;

	static int N, M;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());
		int nums[] = new int[N];
		tokens = new StringTokenizer(input.readLine());
		for (int n = 0; n < N; n++) {
			nums[n] = Integer.parseInt(tokens.nextToken());
		}
		Arrays.sort(nums);

		M = Integer.parseInt(input.readLine());
		tokens = new StringTokenizer(input.readLine());
		for (int m = 0; m < M; m++) {
			int target = Integer.parseInt(tokens.nextToken());
			output.append(upperBound(nums, target) - lowerBound(nums, target)).append(" ");
		}

		System.out.println(output.toString().trim());
	}

	static int lowerBound(int[] nums, int key) {
		int low = 0;
		int high = nums.length;

		while (low < high) {
			int mid = (low + high) / 2;
			if (key <= nums[mid]) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return low;
	}

	static int upperBound(int[] nums, int key) {
		int low = 0;
		int high = nums.length;

		while (low < high) {
			int mid = (low + high) / 2;
			if (key < nums[mid]) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return low;
	}
}