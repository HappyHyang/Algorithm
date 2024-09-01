import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();

		String line;
		while ((line = input.readLine()) != null) {
			output.append(line).append("\n");
		}
		
		System.out.print(output);
	}
}