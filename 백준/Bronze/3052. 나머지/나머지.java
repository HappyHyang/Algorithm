import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	static int T = 10;
	static int SHARE = 42;
	static Set<Integer> REST;

	public static void main(String[] args) throws Exception {
		REST = new HashSet<>();
		for (int i = 0; i < T; i++) {
			REST.add(Integer.parseInt(input.readLine()) % SHARE);
		}
		System.out.println(REST.size());
	}
}