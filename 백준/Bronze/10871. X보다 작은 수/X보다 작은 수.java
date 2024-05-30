import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens = null;

	static int N, X;

	public static void main(String[] args) throws Exception {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		X = Integer.parseInt(tokens.nextToken());
		tokens = new StringTokenizer(input.readLine());
		for (int n = 0; n < N; n++) {
			int num = Integer.parseInt(tokens.nextToken());
			if (num < X) {
				output.append(num).append(" ");
			}
		}
		System.out.println(output.toString().trim());
	}
}