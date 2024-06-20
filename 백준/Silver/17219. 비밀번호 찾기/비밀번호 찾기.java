import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();

	public static void main(String[] args) throws IOException {
		StringTokenizer tokens = new StringTokenizer(input.readLine());
		int N = Integer.parseInt(tokens.nextToken());
		int M = Integer.parseInt(tokens.nextToken());

		HashMap<String, String> info = new HashMap<>();
		for (int n = 0; n < N; n++) {
			tokens = new StringTokenizer(input.readLine());
			info.put(tokens.nextToken(), tokens.nextToken());
		}

		for (int m = 0; m < M; m++) {
			output.append(info.get(input.readLine()) + "\n");
		}
		System.out.print(output);
	}
}