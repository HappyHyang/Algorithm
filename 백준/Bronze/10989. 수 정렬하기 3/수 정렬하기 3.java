import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();

		int N = Integer.parseInt(input.readLine());
		int[] counts = new int[10_000 + 1];
		for (int n = 0; n < N; n++) {
			counts[Integer.parseInt(input.readLine())]++;
		}
		for (int i = 1; i <= 10_000; i++) {
			while (counts[i] > 0) {
				output.append(i).append("\n");
				counts[i]--;
			}
		}
		System.out.print(output);
	}
}