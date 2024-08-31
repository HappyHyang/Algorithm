import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		boolean[] submit = new boolean[31]; // 1 base
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 28; i++) {
			submit[Integer.parseInt(input.readLine())] = true;
		}

		StringBuilder output = new StringBuilder();
		for (int i = 1; i <= 30; i++) {
			if (!submit[i]) {
				output.append(i).append('\n');
			}
		}

		System.out.print(output);
	}
}