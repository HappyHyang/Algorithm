import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] nums;

	static int[] selected;
	static boolean[] used;
	static StringBuilder output = new StringBuilder();

	public static void main(String[] args) throws IOException {
		initialize();
		solution(0, -1);
		System.out.print(output);
	}

	static void initialize() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		nums = new int[N];
		selected = new int[M];
		used = new boolean[N];
		tokens = new StringTokenizer(input.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(tokens.nextToken());
		}
		Arrays.sort(nums);
	}

	static void solution(int cnt, int lastSelected) {
		if (cnt == M) {
			for (int num : selected) {
				output.append(num).append(' ');
			}
			output.append('\n');
			return;
		}

		int lastUsed = -1;
		for (int i = 0; i < N; i++) {
			if (!used[i] && nums[i] != lastUsed) {
				used[i] = true;
				selected[cnt] = nums[i];
				solution(cnt + 1, i);
				used[i] = false;
				lastUsed = nums[i];
			}
		}
	}
}