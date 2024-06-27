import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();

	static Car[] cars;
	static boolean[] connected;

	static class Car {
		int loc;
		int fuel;

		Car(int loc, int fuel) {
			this.loc = loc;
			this.fuel = fuel;
		}
	}

	public static void main(String[] args) throws IOException {
		// init
		StringTokenizer tokens = new StringTokenizer(input.readLine());
		int N = Integer.parseInt(tokens.nextToken()); // 커넥티드 카의 수
		int S = Integer.parseInt(tokens.nextToken()) - 1; // 초기 연결

		cars = new Car[N];
		StringTokenizer locs = new StringTokenizer(input.readLine());
		StringTokenizer fuels = new StringTokenizer(input.readLine());
		for (int i = 0; i < N; i++) {
			int loc = Integer.parseInt(locs.nextToken());
			int fuel = Integer.parseInt(fuels.nextToken());
			cars[i] = new Car(loc, fuel);
		}

		// Solution
		connected = new boolean[N];
		Arrays.sort(cars, (a, b) -> a.loc - b.loc);
		bfs(S, N);

		// Answer
		for (int i = 0; i < N; i++) {
			if (connected[i]) {
				output.append((i + 1) + " ");
			}
		}
		System.out.println(output.toString().trim());
	}

	static void bfs(int start, int N) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		connected[start] = true;

		while (!queue.isEmpty()) {
			int current = queue.poll();
			int minReach = cars[current].loc - cars[current].fuel;
			int maxReach = cars[current].loc + cars[current].fuel;

			for (int i = current - 1; i >= 0 && cars[i].loc >= minReach; i--) {
				if (!connected[i]) {
					connected[i] = true;
					queue.offer(i);
				}
			}

			for (int i = current + 1; i < N && cars[i].loc <= maxReach; i++) {
				if (!connected[i]) {
					connected[i] = true;
					queue.offer(i);
				}
			}
		}
	}
}