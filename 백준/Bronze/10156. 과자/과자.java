import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int K, N, M;

	public static void main(String[] args) throws IOException {
		initialize();
		System.out.println(calcShortAmount());
	}

	static void initialize() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(input.readLine());
		K = Integer.parseInt(tokens.nextToken());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
	}

	static int calcShortAmount() {
		int amount = (K * N) - M;
		return amount > 0 ? amount : 0;
	}
}