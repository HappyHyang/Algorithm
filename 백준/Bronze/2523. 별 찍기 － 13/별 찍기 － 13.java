import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		int N = Integer.parseInt(input.readLine());
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i; j++) {
				output.append('*');
			}
			output.append('\n');
		}
		for (int i = N; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				output.append('*');
			}
			output.append('\n');
		}
		System.out.print(output);
	}
}