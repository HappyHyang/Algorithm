import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();

	public static void main(String[] args) throws Exception {
		String testcase;
		while (!(testcase = input.readLine()).equals("0 0 0")) {
			int[] triangle = Arrays.stream(testcase.split(" ")).mapToInt(Integer::parseInt).toArray();
			output.append(isRightTriangle(triangle) ? "right" : "wrong").append("\n");
		}
		System.out.print(output);
	}

	static boolean isRightTriangle(int[] triangle) {
		Arrays.sort(triangle);
		return (triangle[0] * triangle[0]) + (triangle[1] * triangle[1]) == (triangle[2] * triangle[2]);
	}
}