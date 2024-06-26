import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int TC = Integer.parseInt(input.readLine());
		for (int tc = 0; tc < TC; tc++) {
			int N = Integer.parseInt(input.readLine());
			HashMap<String, Integer> clothes = new HashMap();
			for (int n = 0; n < N; n++) {
				StringTokenizer tokens = new StringTokenizer(input.readLine());
				tokens.nextToken(); // name
				String type = tokens.nextToken();
				clothes.put(type, clothes.getOrDefault(type, 0) + 1);
			}
			int answer = 1;
			for (Integer value : clothes.values()) {
				answer *= (value + 1);
			}
			output.append((answer - 1) + "\n");
		}
		System.out.print(output);
	}
}