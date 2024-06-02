import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(input.readLine());

		int num = 666;
		int count = 1;

		while (count < N) {
			num++;
			if (contains666(num)) {
				count++;
			}
		}
		System.out.print(num);
	}

	static boolean contains666(int num) {
		int consecutiveSixes = 0;
		while (num > 0) {
			if (num % 10 == 6) {
				consecutiveSixes++;
				if (consecutiveSixes == 3) {
					return true;
				}
			} else {
				consecutiveSixes = 0;
			}
			num /= 10;
		}
		return false;
	}
}