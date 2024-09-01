import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();

		int TC = Integer.parseInt(input.readLine());
		while (TC-- > 0) {
			String line = input.readLine();
			output.append(line.charAt(0)).append(line.charAt(line.length() - 1)).append('\n');
		}
		System.out.print(output);
	}
}