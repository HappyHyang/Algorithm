import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		input.readLine();
		System.out.println(input.readLine().chars().map(Character::getNumericValue).sum());
	}
}