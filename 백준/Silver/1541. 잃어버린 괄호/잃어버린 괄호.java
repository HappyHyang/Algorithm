import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String expression = input.readLine();

		String[] subPart = expression.split("-");

		int total = 0;
		boolean first = true;

		for (String s : subPart) {
			int sum = sumOfPart(s);
			if (first) {
				total += sum;
				first = false;
			} else {
				total -= sum;
			}
		}
		System.out.println(total);
	}

	static int sumOfPart(String part) {
		String[] addPart = part.split("\\+");
		int sum = 0;
		for (String s : addPart) {
			sum += Integer.parseInt(s);
		}
		return sum;
	}
}