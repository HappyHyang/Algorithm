import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static String word;
	static String bomb;

	public static void main(String[] args) throws IOException {
		initialize();
		System.out.println(explode());
	}

	static void initialize() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		word = input.readLine();
		bomb = input.readLine();
	}

	static String explode() {
		Stack<Character> answer = new Stack<>();
		int bombLength = bomb.length();

		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			answer.push(c);

			if (answer.size() >= bombLength) {
				boolean isBomb = true;
				for (int j = 0; j < bombLength; j++) {
					if (answer.get(answer.size() - bombLength + j) != bomb.charAt(j)) {
						isBomb = false;
						break;
					}
				}

				if (isBomb) {
					for (int j = 0; j < bombLength; j++) {
						answer.pop();
					}
				}
			}
		}

		if (answer.isEmpty()) {
			return "FRULA";
		}

		StringBuilder output = new StringBuilder();
		for (char c : answer) {
			output.append(c);
		}

		return output.toString();
	}
}