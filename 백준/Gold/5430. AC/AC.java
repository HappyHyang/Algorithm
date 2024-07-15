import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();

	static char[] p;
	static int N;
	static Deque<Integer> deque;

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(input.readLine());
		while (T-- > 0) {
			initialize();
			output.append(solution()).append('\n');
		}
		System.out.print(output);
	}

	static void initialize() throws IOException {
		p = input.readLine().toCharArray();
		N = Integer.parseInt(input.readLine());
		deque = new ArrayDeque<>();
		String str = input.readLine();
		str = str.substring(1, str.length() - 1);
		if (!str.isEmpty()) {
			String[] numbers = str.split(",");
			for (String number : numbers) {
				deque.add(Integer.parseInt(number.trim()));
			}
		}
	}

	static String solution() {
		boolean isFirst = true;
		for (char c : p) {
			switch (c) {
				case 'R':
					isFirst = !isFirst;
					break;
				case 'D':
					if (deque.isEmpty()) {
						return "error";
					} else {
						if (isFirst) {
							deque.pollFirst();
						} else {
							deque.pollLast();
						}
					}
					break;
			}
		}
		return dequeToString(isFirst);
	}

	static String dequeToString(boolean isFirst) {
		StringBuilder array = new StringBuilder("[");
		while (!deque.isEmpty()) {
			array.append(isFirst ? deque.pollFirst() : deque.pollLast());
			if (!deque.isEmpty()) {
				array.append(",");
			}
		}
		array.append("]");
		return array.toString();
	}
}