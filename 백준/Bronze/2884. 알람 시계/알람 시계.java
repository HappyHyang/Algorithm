import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens = null;

	static int H, M;
	static int earlier = 45;

	public static void main(String[] args) throws Exception {
		tokens = new StringTokenizer(input.readLine());
		H = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());

		System.out.println(minToTime(timeToMin(H, M) - earlier));
	}

	static int timeToMin(int hour, int min) {
		return hour * 60 + min;
	}

	static String minToTime(int min) {
		if (min < 0) {
			min += 24 * 60;
		}
		int h = min / 60;
		int m = min % 60;
		return h + " " + m;
	}
}