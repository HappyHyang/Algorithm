import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens;

		// input: N(집의 수)
		int N = Integer.parseInt(input.readLine());

		// input: home(각 집을 빨강, 초록, 파랑으로 칠하는 비용)
		int[][] paintPrice = new int[N][3];
		int[][] d = new int[N][3];
		for (int i = 0; i < N; i++) {
			tokens = new StringTokenizer(input.readLine());
			for (int j = 0; j < 3; j++) { // RGB
				// input: paintPrice(집 별 RGB 비용)
				paintPrice[i][j] = Integer.parseInt(tokens.nextToken());

				if (i == 0) {
					d[i][j] = paintPrice[i][j];
				} else {
					if (j == 0) {
						d[i][j] = Math.min(d[i - 1][1], d[i - 1][2]) + paintPrice[i][j];
					} else if (j == 1) {
						d[i][j] = Math.min(d[i - 1][0], d[i - 1][2]) + paintPrice[i][j];
					} else {
						d[i][j] = Math.min(d[i - 1][0], d[i - 1][1]) + paintPrice[i][j];
					}
				}
			}
		}

		// 최소 비용 선택
		int answer = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			answer = Math.min(d[N - 1][i], answer);
		}

		// output: 정답 출력
		System.out.println(answer);
	}

}