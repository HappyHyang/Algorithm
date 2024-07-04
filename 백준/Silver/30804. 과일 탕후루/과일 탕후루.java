import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	static int N, fruits[];

	public static void main(String[] args) throws IOException {
		initialize();
		System.out.println(solution());
	}

	static void initialize() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(input.readLine());
		fruits = new int[N];
		StringTokenizer tokens = new StringTokenizer(input.readLine());
		for (int n = 0; n < N; n++) {
			fruits[n] = Integer.parseInt(tokens.nextToken());
		}
	}

	static int solution() {
		int answer = 0;

		HashMap<Integer, Integer> fruitCnt = new HashMap<>();
		int left = 0;
		for (int right = 0; right < N; right++) {
			fruitCnt.put(fruits[right], fruitCnt.getOrDefault(fruits[right], 0) + 1);
			while (fruitCnt.size() > 2) {
				fruitCnt.put(fruits[left], fruitCnt.get(fruits[left]) - 1);
				if (fruitCnt.get(fruits[left]) == 0) {
					fruitCnt.remove(fruits[left]);
				}
				left++;
			}
			answer = Math.max(answer, right - left + 1);
		}

		return answer;
	}
}