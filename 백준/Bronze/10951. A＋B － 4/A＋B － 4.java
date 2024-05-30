import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens = null;

	public static void main(String[] args) throws Exception {
		String testcase;
		while ((testcase = input.readLine()) != null) {
			tokens = new StringTokenizer(testcase);
			int A = Integer.parseInt(tokens.nextToken());
			int B = Integer.parseInt(tokens.nextToken());
			output.append(A + B).append("\n");
		}
		System.out.print(output);
	}
}