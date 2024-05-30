import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();

	public static void main(String[] args) throws Exception {
		String word = input.readLine();

		for (char ch = 'a'; ch <= 'z'; ch++) {
			output.append(word.indexOf(ch)).append(" ");
		}

		System.out.println(output.toString().trim());
	}
}