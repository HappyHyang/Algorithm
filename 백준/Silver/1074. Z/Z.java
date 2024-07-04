import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, r, c;

	public static void main(String[] args) throws IOException {
		initialize();
		System.out.println(solution(0, 0, (1 << N)));
	}

	static void initialize() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		r = Integer.parseInt(tokens.nextToken());
		c = Integer.parseInt(tokens.nextToken());
	}

	static int solution(int x, int y, int size) {
		if (size == 1) {
			return 0;
		}

		int half = size / 2;
		int cnt = half * half;

		if (r < x + half && c < y + half) {
			return solution(x, y, half);
		} else if (r < x + half && c >= y + half) {
			return cnt + solution(x, y + half, half);
		} else if (r >= x + half && c < y + half) {
			return cnt * 2 + solution(x + half, y, half);
		} else {
			return cnt * 3 + solution(x + half, y + half, half);
		}
	}
}