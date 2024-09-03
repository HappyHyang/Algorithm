import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		double score = 0.0;
		String grade = input.readLine();
		if (grade.length() == 2) {
			score += 69 - grade.charAt(0);
			if (grade.charAt(1) == '+') {
				score += 0.3;
			} else if (grade.charAt(1) == '-') {
				score -= 0.3;
			}
		}
		System.out.println(score);
	}
}