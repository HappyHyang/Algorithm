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
		String Pn = makePn();
		int[] pi = prefix(Pn);
		int answer = 0;
		int j = 0;

		for (int i = 0; i < M; i++) {
			while (j > 0 && str.charAt(i) != Pn.charAt(j)) {
				j = pi[j - 1];
			}
			if (str.charAt(i) == Pn.charAt(j)) {
				if (j == Pn.length() - 1) {
					answer++;
					j = pi[j];
				} else {
					j++;
				}
			}
		}
		return answer;
	}

	static int[] prefix(String Pn) {
		int m = Pn.length();
		int[] pi = new int[m];
		int j = 0;
		for (int i = 1; i < m; i++) {
			while (j > 0 && Pn.charAt(i) != Pn.charAt(j)) {
				j = pi[j - 1];
			}
			if (Pn.charAt(i) == Pn.charAt(j)) {
				pi[i] = ++j;
			}
		}
		return pi;
	}
}