import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int A, B;

	public static void main(String[] args) throws IOException {
		initialize();
		System.out.println(calcRectangle(A, B));
	}

	static void initialize() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		A = Integer.parseInt(input.readLine());
		B = Integer.parseInt(input.readLine());
	}

	static int calcRectangle(int width, int height) {
		return width * height;
	}
}