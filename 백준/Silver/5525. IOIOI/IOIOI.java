import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N, M;
	static String str;

	public static void main(String[] args) throws IOException {
		initialize();
		System.out.println(solution());
	}

	static void initialize() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(input.readLine());
		M = Integer.parseInt(input.readLine());
		str = input.readLine();
	}

	static String makePn() {
		StringBuilder Pn = new StringBuilder();
		Pn.append('I');
		for (int n = 0; n < N; n++) {
			Pn.append("OI");
		}
		return Pn.toString();
	}

	static int solution() {
		int answer = 0;
		String Pn = makePn();
		for (int i = 0; i <= M - Pn.length(); i++) {
			if (str.substring(i, i + Pn.length()).equals(Pn)) {
				answer++;
			}
		}
		return answer;
	}
}