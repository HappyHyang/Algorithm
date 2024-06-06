import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int num = 0;
		for (int i = 3; i > 0; i--) {
			String str = input.readLine();
			if (isNumberic(str)) {
				num = Integer.parseInt(str) + i;
				break;
			}
		}

		if (num % 3 == 0 && num % 5 == 0) {
			System.out.println("FizzBuzz");
		} else if (num % 3 == 0) {
			System.out.println("Fizz");
		} else if (num % 5 == 0) {
			System.out.println("Buzz");
		} else {
			System.out.println(num);
		}
	}

	static boolean isNumberic(String str) {
		return str.matches("[+-]?\\d*(\\.\\d+)?");
	}
}