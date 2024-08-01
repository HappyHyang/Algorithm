import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static String A, B;

	public static void main(String[] args) throws IOException {
		initialize();
		System.out.println(addBinary());
	}

	static void initialize() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(input.readLine().trim());
		A = tokens.nextToken();
		B = tokens.nextToken();
	}

	static String addBinary() {
		StringBuilder result = new StringBuilder();
		int i = A.length() - 1;
		int j = B.length() - 1;
		int carry = 0;

		while (i >= 0 || j >= 0) {
			int sum = carry;
			if (i >= 0) {
				sum += A.charAt(i--) - '0';
			}
			if (j >= 0) {
				sum += B.charAt(j--) - '0';
			}
			result.append(sum % 2);
			carry = sum / 2;
		}
		if (carry != 0) {
			result.append(carry);
		}
		result.reverse();
		
		while (result.length() > 1 && result.charAt(0) == '0') {
			result.deleteCharAt(0);
		}
		return result.toString();
	}
}