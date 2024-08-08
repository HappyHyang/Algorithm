import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		long count = input.readLine().chars()
			.filter(c -> "aeiou".indexOf(c) != -1)
			.count();
		System.out.println(count);
	}
}