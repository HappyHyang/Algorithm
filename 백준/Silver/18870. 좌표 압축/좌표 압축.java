import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static class Coordinate implements Comparable<Coordinate> {
		int value;
		int idx;

		Coordinate(int value, int idx) {
			this.value = value;
			this.idx = idx;
		}

		@Override
		public int compareTo(Coordinate other) {
			return Integer.compare(this.value, other.value);
		}
	}

	static StringBuilder output = new StringBuilder();
	static int N;
	static Coordinate[] X;

	public static void main(String[] args) throws IOException {
		initialize();
		solution();
	}

	static void initialize() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(input.readLine());

		X = new Coordinate[N];
		StringTokenizer tokens = new StringTokenizer(input.readLine());
		for (int n = 0; n < N; n++) {
			X[n] = new Coordinate(Integer.parseInt(tokens.nextToken()), n);
		}
	}

	static void solution() {
		Arrays.sort(X);
		int[] answer = new int[N];
		int prev = X[0].value;
		int compressedIdx = 0;
		for (int n = 0; n < N; n++) {
			if (prev != X[n].value) {
				compressedIdx++;
			}
			answer[X[n].idx] = compressedIdx;
			prev = X[n].value;
		}

		for (int i : answer) {
			output.append(i + " ");
		}
		System.out.println(output.toString().trim());
	}
}