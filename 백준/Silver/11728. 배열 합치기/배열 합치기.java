import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		input.readLine();

		int[] a = Arrays.stream(input.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();

		int[] b = Arrays.stream(input.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();

		System.out.println(mergeArrays(a, b));
	}

	private static String mergeArrays(int[] a, int[] b) {
		int n = a.length, m = b.length;
		int[] merged = new int[n + m];
		int i = 0, j = 0, k = 0;

		while (i < n && j < m) {
			if (a[i] <= b[j]) {
				merged[k++] = a[i++];
			} else {
				merged[k++] = b[j++];
			}
		}

		while (i < n) {
			merged[k++] = a[i++];
		}
		while (j < m) {
			merged[k++] = b[j++];
		}

		return Arrays.stream(merged)
			.mapToObj(String::valueOf)
			.collect(Collectors.joining(" "));
	}
}