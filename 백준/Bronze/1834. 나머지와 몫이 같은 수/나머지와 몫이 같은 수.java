import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(input.readLine());
		System.out.println(solution(N));
	}

	static long solution(long num) {
		long sum = 0;
		for (int i = 1; i < num; i++) {
			sum += (num + 1) * i;
		}
		return sum;
	}
}