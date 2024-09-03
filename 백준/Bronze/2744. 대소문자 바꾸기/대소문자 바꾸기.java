import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		char[] word = input.readLine().toCharArray();
		StringBuilder output = new StringBuilder();
		for (char c : word) {
			if (Character.isLowerCase(c)) {
				output.append(Character.toUpperCase(c));
			} else {
				output.append(Character.toLowerCase(c));
			}
		}
		System.out.println(output);
	}
}