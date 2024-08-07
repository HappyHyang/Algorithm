import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(input.readLine());
		BigInteger A = new BigInteger(tokenizer.nextToken());
		BigInteger B = new BigInteger(tokenizer.nextToken());
		System.out.println(A.multiply(B));
	}
}