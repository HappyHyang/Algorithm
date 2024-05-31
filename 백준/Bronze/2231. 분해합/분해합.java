import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(solution(Integer.parseInt(input.readLine())));
	}

	static int solution(int n) {
		for (int i = 1; i < n; i++) {
			int sum = i;
			int number = i;

			while (number != 0) {
				sum += number % 10;
				number /= 10;
			}

			if (sum == n) {
				return i;
			}
		}
		return 0;
	}
}