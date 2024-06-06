import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens = null;

	static int N, T, P, sizes[];

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());

		sizes = new int[6];
		tokens = new StringTokenizer(input.readLine());
		for (int i = 0; i < 6; i++) {
			sizes[i] = Integer.parseInt(tokens.nextToken());
		}

		tokens = new StringTokenizer(input.readLine());
		T = Integer.parseInt(tokens.nextToken());
		P = Integer.parseInt(tokens.nextToken());

		int cntT = 0;
		for (int size : sizes) {
			cntT += size / T;
			if (size % T != 0) {
				cntT++;
			}
		}

		int cntBundleP = N / P;
		int cntP = N % P;

		output.append(cntT).append("\n");
		output.append(cntBundleP + " " + cntP);
		System.out.println(output);
	}
}