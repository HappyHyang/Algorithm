import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		int[] count = new int[26];
		int maxCount = 0;
		char answer = '?';

		String word = input.readLine().toUpperCase();
		for (char c : word.toCharArray()) {
			count[c - 'A']++;
		}

		for (int i = 0; i < count.length; i++) {
			if (count[i] > maxCount) {
				maxCount = count[i];
				answer = (char)(i + 'A');
			} else if (count[i] == maxCount) {
				answer = '?';
			}
		}

		System.out.println(answer);
	}
}