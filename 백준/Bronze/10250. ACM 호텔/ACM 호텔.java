import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens = null;

	static int T;

	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(input.readLine());
		for (int t = 0; t < T; t++) {
			tokens = new StringTokenizer(input.readLine());
			int H = Integer.parseInt(tokens.nextToken());
			tokens.nextToken(); // W
			int N = Integer.parseInt(tokens.nextToken());

			output.append(calcRoomNum(H, N) + "\n");
		}
		System.out.println(output);
	}

	static int calcRoomNum(int h, int n) {
		int floor = n % h == 0 ? h : n % h;
		floor *= 100;
		int num = n % h == 0 ? n / h : (n / h) + 1;
		return floor + num;
	}
}