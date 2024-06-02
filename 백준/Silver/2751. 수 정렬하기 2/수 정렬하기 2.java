import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();

		int N = Integer.parseInt(input.readLine());
		ArrayList<Integer> nums = new ArrayList<>();

		for (int n = 0; n < N; n++) {
			nums.add(Integer.parseInt(input.readLine()));
		}
		Collections.sort(nums);
		for (int num : nums) {
			output.append(num).append("\n");
		}
		System.out.print(output);
	}
}