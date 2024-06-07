import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens = null;

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(input.readLine());
		tokens = new StringTokenizer(input.readLine());
		int[] nums = new int[N];
		for (int n = 0; n < N; n++) {
			nums[n] = Integer.parseInt(tokens.nextToken());
		}
		Arrays.sort(nums);

		int M = Integer.parseInt(input.readLine());
		tokens = new StringTokenizer(input.readLine());
		for (int m = 0; m < M; m++) {
			output.append(binarySearch(nums, Integer.parseInt(tokens.nextToken())) ? 1 : 0).append("\n");
		}

		System.out.print(output);
	}

	static boolean binarySearch(int[] nums, int num) {
		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {
			int mid = (left + right) / 2;

			if (nums[mid] == num) {
				return true;
			} else if (nums[mid] < num) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return false;
	}
}