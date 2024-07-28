import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BigInteger N = new BigInteger(input.readLine());
		boolean foundPalindrome = false;
		StringBuilder output = new StringBuilder();
		for (int i = 2; i <= 10; i++) {
			String converted = convertSystem(N, BigInteger.valueOf(i));
			if (isPalindrom(converted)) {
				output.append(i).append(' ').append(converted).append('\n');
				foundPalindrome = true;
			}
		}
		if (!foundPalindrome) {
			output.append("NIE");
		}
		System.out.print(output);
	}

	static String convertSystem(BigInteger num, BigInteger system) {
		StringBuilder result = new StringBuilder();
		while (!num.equals(BigInteger.ZERO)) {
			result.insert(0, num.mod(system));
			num = num.divide(system);
		}
		return result.toString();
	}

	static boolean isPalindrom(String str) {
		return str.contentEquals(new StringBuilder(str).reverse());
	}
}