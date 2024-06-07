import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(input.readLine());

		Queue<Integer> cards = new LinkedList<>();
		for (int n = 1; n <= N; n++) {
			cards.add(n);
		}

		while (cards.size() > 1) {
			cards.poll();
			cards.add(cards.poll());
		}

		System.out.println(cards.poll());
	}
}