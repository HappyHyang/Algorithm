import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens = null;

	static int answer = 0;

	public static void main(String[] args) throws Exception {
		tokens = new StringTokenizer(input.readLine());

		for (int i = 0; i < 5; i++) {
			int num = Integer.parseInt(tokens.nextToken());
			answer += num * num;
		}

		System.out.println(answer % 10);
	}
}