import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		input.readLine();
		char[] word = input.readLine().toCharArray();
		long answer = 0;
		long pow = 1;
		for (int i = 0; i < word.length; i++) {
			answer += (word[i] - 'a' + 1) * pow;
			pow *= 31;
		}
		System.out.println(answer);
	}
}