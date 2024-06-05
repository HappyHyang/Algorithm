import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();

	static String A, B;
	static int C;

	public static void main(String[] args) throws IOException {
		A = input.readLine();
		B = input.readLine();
		C = Integer.parseInt(input.readLine());

		output.append(Integer.parseInt(A) + Integer.parseInt(B) - C).append("\n");
		output.append(Integer.parseInt(A + B) - C);

		System.out.println(output);
	}
}