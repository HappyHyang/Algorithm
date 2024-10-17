import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();

		String line;
		while ((line = input.readLine()) != null) {
			int lowerCnt = 0, upperCnt = 0, numCnt = 0, spaceCnt = 0;

			for (int i = 0; i < line.length(); i++) {
				char c = line.charAt(i);

				if (Character.isLowerCase(c)) {
					lowerCnt++;
				} else if (Character.isUpperCase(c)) {
					upperCnt++;
				} else if (Character.isDigit(c)) {
					numCnt++;
				} else if (c == ' ') {
					spaceCnt++;
				}
			}
			output.append(lowerCnt).append(' ');
			output.append(upperCnt).append(' ');
			output.append(numCnt).append(' ');
			output.append(spaceCnt).append('\n');
		}

		System.out.print(output);
	}
}