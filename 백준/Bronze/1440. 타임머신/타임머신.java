import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[] time;

	public static void main(String[] args) throws IOException {
		initiazlie();
		System.out.println(countPossibleTime());
	}

	static void initiazlie() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		time = Arrays.stream(input.readLine().split(":")).mapToInt(Integer::parseInt).toArray();
	}

	static int countPossibleTime() {
		int count = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					if (i != j && j != k && k != i) {
						int hour = time[i];
						int min = time[j];
						int sec = time[k];
						if (isPossible(hour, min, sec)) {
							count++;
						}
					}
				}
			}
		}
		return count;
	}

	static boolean isPossible(int hour, int min, int sec) {
		return (1 <= hour && hour <= 12) && (min < 60) && (sec < 60);
	}
}