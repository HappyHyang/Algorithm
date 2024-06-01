import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(input.readLine());
		int N = Integer.parseInt(tokens.nextToken());
		int K = Integer.parseInt(tokens.nextToken());
		System.out.println(binoCoef(N, K));
	}

	static int binoCoef(int n, int k) {
		if (k == 0 || n == k) {
			return 1;
		}
		return binoCoef(n - 1, k) + binoCoef(n - 1, k - 1);
	}
}