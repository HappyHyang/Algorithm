import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();

	static int N;
	static String[] words;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());

		words = new String[N];
		for (int n = 0; n < N; n++) {
			words[n] = input.readLine();
		}

		// 중복 제거
		LinkedHashSet<String> wordSet = new LinkedHashSet<>(Arrays.asList(words));
		words = wordSet.toArray(new String[0]);

		// 정렬
		Arrays.sort(words, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o1.length() == o2.length()) {
					return o1.compareTo(o2);
				} else {
					return Integer.compare(o1.length(), o2.length());
				}
			}
		});

		for (String word : words) {
			output.append(word).append("\n");
		}
		System.out.print(output);
	}
}