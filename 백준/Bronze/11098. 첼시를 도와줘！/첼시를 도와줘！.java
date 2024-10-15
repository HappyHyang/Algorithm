import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();

		int TC = Integer.parseInt(input.readLine());
		while (TC-- > 0) {
			String maxName = "";
			int maxValue = 0;

			int p = Integer.parseInt(input.readLine());
			while (p-- > 0) {
				String[] info = input.readLine().split(" ");
				int value = Integer.parseInt(info[0]);
				if (value > maxValue) {
					maxValue = value;
					maxName = info[1];
				}
			}
			output.append(maxName).append('\n');
		}
		System.out.print(output);
	}
}