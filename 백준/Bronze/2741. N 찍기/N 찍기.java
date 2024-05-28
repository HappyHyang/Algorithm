import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();

	static int N;

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(input.readLine());
		for (int n = 1; n <= N; n++) {
			output.append(n + "\n");
		}
		System.out.print(output);
	}
}