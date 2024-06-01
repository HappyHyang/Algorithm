import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();

	/**
	 * TC: 테스트케이스 수
	 * k: 층 (0-base)
	 * n: 호 (1-base)
	 */
	static int TC, k, n;

	public static void main(String[] args) throws IOException {
		TC = Integer.parseInt(input.readLine());

		for (int tc = 0; tc < TC; tc++) {
			k = Integer.parseInt(input.readLine());
			n = Integer.parseInt(input.readLine());
			output.append(getResidentsNum(k, n)).append("\n");
		}

		System.out.print(output);
	}

	static int getResidentsNum(int k, int n) {
		int[][] apartment = new int[k + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			apartment[0][i] = i;
		}

		for (int i = 1; i <= k; i++) {
			for (int j = 1; j <= n; j++) {
				apartment[i][j] = apartment[i][j - 1] + apartment[i - 1][j];
			}
		}

		return apartment[k][n];
	}
}