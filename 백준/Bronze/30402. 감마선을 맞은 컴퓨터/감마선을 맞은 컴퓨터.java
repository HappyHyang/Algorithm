import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = null;
		for (int row = 0; row < 15; row++) {
			tokens = new StringTokenizer(input.readLine());
			for (int col = 0; col < 15; col++) {
				switch (tokens.nextToken()) {
					case "w":
						System.out.println("chunbae");
						return;
					case "b":
						System.out.println("nabi");
						return;
					case "g":
						System.out.println("yeongcheol");
						return;
				}
			}
		}
	}
}