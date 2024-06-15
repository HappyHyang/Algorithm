import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int M = Integer.parseInt(input.readLine());
		int bit = 0;

		for (int m = 0; m < M; m++) {
			StringTokenizer tokens = new StringTokenizer(input.readLine());
			String command = tokens.nextToken();

			switch (command) {
				case "add":
					bit |= (1 << Integer.parseInt(tokens.nextToken()));
					break;
				case "remove":
					bit &= ~(1 << Integer.parseInt(tokens.nextToken()));
					break;
				case "check":
					output.append((bit & (1 << Integer.parseInt(tokens.nextToken()))) != 0 ? 1 : 0).append("\n");
					break;
				case "toggle":
					bit ^= (1 << Integer.parseInt(tokens.nextToken()));
					break;
				case "all":
					bit = (1 << 21) - 1;
					break;
				case "empty":
					bit = 0;
					break;
			}
		}
		System.out.print(output);
	}
}