import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();

	static int TC;

	public static void main(String[] args) throws Exception {
		TC = Integer.parseInt(input.readLine());
		for (int tc = 0; tc < TC; tc++) {
			String result = input.readLine();
			output.append(calcScore(result) + "\n");
		}
		System.out.print(output);
	}

	static int calcScore(String result) {
		int score = 0;
		int previous = 0;

		for (char c : result.toCharArray()) {
			switch (c) {
				case 'O':
					previous++;
					break;
				case 'X':
					previous = 0;
					break;
			}
			score += previous;
		}

		return score;
	}
}