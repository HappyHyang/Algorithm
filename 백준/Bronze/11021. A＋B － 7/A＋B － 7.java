import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();

		int T = Integer.parseInt(input.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int[] nums = Arrays.stream(input.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
			output.append("Case #" + tc + ": ").append(nums[0] + nums[1]).append('\n');
		}

		System.out.print(output);
	}
}