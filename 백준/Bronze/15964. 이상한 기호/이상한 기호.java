import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(input.readLine());
		long A = Long.parseLong(tokenizer.nextToken());
		long B = Long.parseLong(tokenizer.nextToken());
		System.out.println((A + B) * (A - B));
	}
}