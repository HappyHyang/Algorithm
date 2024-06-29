import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		StringTokenizer tokens = new StringTokenizer(input.readLine());
		int N = Integer.parseInt(tokens.nextToken());
		long M = Long.parseLong(tokens.nextToken());

		int[] trees = new int[N];
		int highest = 0;

		tokens = new StringTokenizer(input.readLine());
		for (int i = 0; i < N; i++) {
			trees[i] = Integer.parseInt(tokens.nextToken());
			if (trees[i] > highest) {
				highest = trees[i];
			}
		}

		int low = 0, high = highest, result = 0;
		while (low <= high) {
			int mid = (low + high) / 2;
			long sum = 0;
			for (int tree : trees) {
				if (tree > mid) {
					sum += tree - mid;
				}
			}

			if (sum >= M) {
				result = mid;
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		System.out.println(result);
	}
}