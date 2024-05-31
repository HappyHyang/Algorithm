import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(input.readLine());
		tokens.nextToken();
		int M = Integer.parseInt(tokens.nextToken());
		int[] cards = Arrays.stream(input.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int max = 0;
		for (int i = 0; i < cards.length - 2; i++) {
			if (cards[i] > M)
				continue;
			for (int j = i + 1; j < cards.length - 1; j++) {
				if (cards[i] + cards[j] > M)
					continue;
				for (int k = j + 1; k < cards.length; k++) {
					int sum = cards[i] + cards[j] + cards[k];
					if (max < sum && sum <= M) {
						max = sum;
					}
				}
			}
		}
		System.out.println(max);
	}
}