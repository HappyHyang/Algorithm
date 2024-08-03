import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[] nums;

	public static void main(String[] args) throws IOException {
		initialize();
		System.out.println(luckTicketMaxLength());
	}

	static void initialize() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		nums = Arrays.stream(input.readLine().split("")).mapToInt(Integer::parseInt).toArray();
	}

	static int luckTicketMaxLength() {
		for (int len = nums.length - (nums.length % 2); len > 0; len -= 2) {
			for (int start = 0; start <= nums.length - len; start++) {
				int mid = start + len / 2;
				int leftSum = 0, rightSum = 0;

				for (int i = 0; i < mid - start; i++) {
					leftSum += nums[start + i];
					rightSum += nums[mid + i];
				}

				if (leftSum == rightSum) {
					return len;
				}
			}
		}
		return 0;
	}
}