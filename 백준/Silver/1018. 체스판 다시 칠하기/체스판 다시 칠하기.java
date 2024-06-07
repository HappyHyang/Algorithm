import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens = null;

	static int N, M, answer;
	static boolean board[][];

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());

		board = new boolean[N][M];
		for (int n = 0; n < N; n++) {
			String line = input.readLine();
			for (int m = 0; m < M; m++) {
				board[n][m] = line.charAt(m) == 'W';
			}
		}

		answer = Integer.MAX_VALUE;
		for (int n = 0; n <= N - 8; n++) {
			for (int m = 0; m <= M - 8; m++) {
				answer = Math.min(answer, checkBoard(n, m));
			}
		}

		System.out.println(answer);
	}

	static int checkBoard(int x, int y) {
		boolean startB = false;
		boolean startW = true;

		int cntB = 0;
		int cntW = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (board[x + i][y + j] != startB) {
					cntB++;
				}
				
				if (board[x + i][y + j] != startW) {
					cntW++;
				}
				startB = !startB;
				startW = !startW;
			}
			startB = !startB;
			startW = !startW;
		}
		return Math.min(cntB, cntW);
	}
}