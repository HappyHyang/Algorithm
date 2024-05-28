import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		switch (input.readLine()) {
			case "1 2 3 4 5 6 7 8":
				System.out.println("ascending");
				break;
			case "8 7 6 5 4 3 2 1":
				System.out.println("descending");
				break;
			default:
				System.out.println("mixed");
				break;
		}
	}
}