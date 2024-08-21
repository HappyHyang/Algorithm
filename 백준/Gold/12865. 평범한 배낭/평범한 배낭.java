import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static Item[] items;

	public static void main(String[] args) throws IOException {
		initialize();
		System.out.println(pack());
	}

	static void initialize() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokenizer.nextToken());
		K = Integer.parseInt(tokenizer.nextToken());

		items = new Item[N];
		for (int n = 0; n < N; n++) {
			tokenizer = new StringTokenizer(input.readLine());
			int weight = Integer.parseInt(tokenizer.nextToken());
			int value = Integer.parseInt(tokenizer.nextToken());
			items[n] = new Item(weight, value);
		}
	}

	static int pack() {
		int[] dp = new int[K + 1];
		for (int i = 0; i < N; i++) {
			for (int j = K; j >= items[i].weight; j--) {
				dp[j] = Math.max(dp[j], dp[j - items[i].weight] + items[i].value);
			}
		}
		return dp[K];
	}

	static class Item {
		int weight;
		int value;

		Item(int weight, int value) {
			this.weight = weight;
			this.value = value;
		}
	}
}