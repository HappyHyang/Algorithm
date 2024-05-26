import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();

	static int N;

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(input.readLine());

		for (int n = 1; n < N + 1; n++) {
			for (int i = 0; i < N - n; i++) {
				output.append(" ");
			}
			for (int i = 0; i < n; i++) {
				output.append("*");
			}
			output.append("\n");
		}
		System.out.print(output);
	}
}