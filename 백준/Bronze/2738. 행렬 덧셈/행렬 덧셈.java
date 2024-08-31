import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokenizer = null;

	static int N, M;
	static int[][] A, B;

	public static void main(String[] args) throws IOException {
		initialize();
		int[][] answer = addArray();

		StringBuilder output = new StringBuilder();
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < M; col++) {
				output.append(answer[row][col]).append(' ');
			}
			output.append('\n');
		}
		System.out.print(output);
	}

	static void initialize() throws IOException {
		tokenizer = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokenizer.nextToken());
		M = Integer.parseInt(tokenizer.nextToken());

		A = new int[N][M];
		B = new int[N][M];
		inputArray(A);
		inputArray(B);
	}

	static void inputArray(int[][] array) throws IOException {
		for (int row = 0; row < N; row++) {
			tokenizer = new StringTokenizer(input.readLine());
			for (int col = 0; col < M; col++) {
				array[row][col] = Integer.parseInt(tokenizer.nextToken());
			}
		}
	}

	static int[][] addArray() {
		int[][] result = new int[N][M];
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < M; col++) {
				result[row][col] = A[row][col] + B[row][col];
			}
		}
		return result;
	}
}