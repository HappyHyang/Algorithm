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
		int mod = 1234567891;

		for (int i = 0; i < word.length; i++) {
			answer = (answer + (word[i] - 'a' + 1) * pow) % mod;
			pow = (pow * 31) % mod;
		}
		System.out.println(answer);
	}
}