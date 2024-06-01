import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		StringTokenizer tokens = new StringTokenizer(input.readLine());

		int x = Integer.parseInt(tokens.nextToken());
		int y = Integer.parseInt(tokens.nextToken());

		int gcd = getGCD(x, y);
		int lcm = getLCM(x, y, gcd);

		output.append(gcd).append("\n");
		output.append(lcm);
		System.out.println(output);
	}

	/**
	 * 유클리드 호제법을 사용하여 최대공약수를 구함
	 * @param x 첫 번째 정수
	 * @param y 두 번째 정수
	 * @return 최대공약수
	 */
	static int getGCD(int x, int y) {
		if (x % y == 0) {
			return y;
		}
		return getGCD(y, x % y);
	}

	/**
	 * 최소공배수를 구함
	 * @param x 첫 번째 정수
	 * @param y 두 번째 정수
	 * @param gcd 최대공약수
	 * @return 최소공배수
	 */
	static int getLCM(int x, int y, int gcd) {
		return (x * y) / gcd;
	}
}