import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static Point[] points = new Point[3];

	public static void main(String[] args) throws IOException {
		initialize();
		if (isStraight()) {
			System.out.println("WHERE IS MY CHICKEN?");
		} else {
			System.out.println("WINNER WINNER CHICKEN DINNER!");
		}
	}

	static void initialize() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 3; i++) {
			StringTokenizer tokenizer = new StringTokenizer(input.readLine());
			int x = Integer.parseInt(tokenizer.nextToken());
			int y = Integer.parseInt(tokenizer.nextToken());
			points[i] = new Point(x, y);
		}
	}

	static boolean isStraight() {
		return (points[1].x - points[0].x) * (points[2].y - points[0].y)
			== (points[1].y - points[0].y) * (points[2].x - points[0].x);
	}
}