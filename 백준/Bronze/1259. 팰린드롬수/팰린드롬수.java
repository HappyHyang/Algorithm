import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();

		String word;
		while (!(word = input.readLine()).equals("0")) {
			output.append(isPalindrom(word) ? "yes" : "no").append("\n");
		}
		System.out.print(output);
	}

	static boolean isPalindrom(String word) {
		int length = word.length();
		for (int i = 0; i < length / 2; i++) {
			if (word.charAt(i) != word.charAt(length - i - 1)) {
				return false;
			}
		}
		return true;
	}
}