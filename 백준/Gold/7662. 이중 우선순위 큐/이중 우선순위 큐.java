import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		StringBuilder output = new StringBuilder();
		int T = Integer.parseInt(input.readLine());
		while (T-- > 0) {
			output.append(solution()).append('\n');
		}
		System.out.print(output);
	}

	static String solution() throws IOException {
		int K = Integer.parseInt(input.readLine());
		TreeMap<Integer, Integer> map = new TreeMap<>();

		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(input.readLine(), " ");
			String command = st.nextToken();
			int number = Integer.parseInt(st.nextToken());

			switch (command) {
				case "I":
					map.put(number, map.getOrDefault(number, 0) + 1);
					break;
				case "D":
					if (map.isEmpty())
						continue;
					int key = (number == 1) ? map.lastKey() : map.firstKey();
					if (map.put(key, map.get(key) - 1) == 1) {
						map.remove(key);
					}
					break;
			}
		}

		if (map.isEmpty()) {
			return "EMPTY";
		} else {
			return map.lastKey() + " " + map.firstKey();
		}
	}
}