import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(input.readLine().split(" ")[0]);
		StringBuilder output = new StringBuilder();
		for (int n = 0; n < N; n++) {
			output.append(new StringBuilder(input.readLine()).reverse()).append('\n');
		}
		System.out.print(output);
	}
}