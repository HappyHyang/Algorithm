import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] nums;

	static int[] selected;
	static StringBuilder output = new StringBuilder();

	public static void main(String[] args) throws IOException {
		initialize();
		solution(0, 0);
		System.out.print(output);
	}

	static void initialize() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokenizer.nextToken());
		M = Integer.parseInt(tokenizer.nextToken());
		tokenizer = new StringTokenizer(input.readLine());
		Set<Integer> numbers = new HashSet<>();
		for (int n = 0; n < N; n++) {
			numbers.add(Integer.parseInt(tokenizer.nextToken()));
		}
		nums = numbers.stream().mapToInt(Integer::intValue).toArray();
		Arrays.sort(nums);
		selected = new int[M];
	}

	static void solution(int start, int cnt) {
		if (cnt == M) {
			for (int num : selected) {
				output.append(num).append(' ');
			}
			output.append('\n');
			return;
		}
		for (int i = start; i < nums.length; i++) {
			selected[cnt] = nums[i];
			solution(i, cnt + 1);
		}
	}
}