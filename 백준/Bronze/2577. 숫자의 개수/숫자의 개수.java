import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();

	static int A, B, C;
	static int[] num = new int[10];

	public static void main(String[] args) throws Exception {
		A = Integer.parseInt(input.readLine());
		B = Integer.parseInt(input.readLine());
		C = Integer.parseInt(input.readLine());

		String multiply = String.valueOf(A * B * C);

		for (char c : multiply.toCharArray()) {
			num[c - '0']++;
		}

		for (int i : num) {
			output.append(i + "\n");
		}

		System.out.print(output);
	}
}