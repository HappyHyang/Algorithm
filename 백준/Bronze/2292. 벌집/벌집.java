import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(input.readLine());
		int cnt = 1;
		int end = 1;
		while (end < N) {
			end += cnt * 6;
			cnt++;
		}
		System.out.println(cnt);
	}
}