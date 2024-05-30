import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens = null;

	static int T;

	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(input.readLine());

		for (int t = 0; t < T; t++) {
			tokens = new StringTokenizer(input.readLine());
			output.append(Integer.parseInt(tokens.nextToken()) + Integer.parseInt(tokens.nextToken())).append("\n");
		}

		System.out.print(output);
	}
}