import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static List<List<Bus>> busRoute = new ArrayList<>();
	static int start, destination;

	public static void main(String[] args) throws IOException {
		initialize();
		System.out.println(dijkstra());
	}

	static void initialize() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(input.readLine());
		M = Integer.parseInt(input.readLine());

		for (int i = 0; i < N + 1; i++) {
			busRoute.add(new ArrayList<>());
		}
		for (int m = 0; m < M; m++) {
			StringTokenizer tokenizer = new StringTokenizer(input.readLine());
			int start = Integer.parseInt(tokenizer.nextToken());
			int end = Integer.parseInt(tokenizer.nextToken());
			int fare = Integer.parseInt(tokenizer.nextToken());
			busRoute.get(start).add(new Bus(end, fare));
		}

		StringTokenizer tokenizer = new StringTokenizer(input.readLine());
		start = Integer.parseInt(tokenizer.nextToken());
		destination = Integer.parseInt(tokenizer.nextToken());
	}

	static int dijkstra() {
		int[] fare = new int[N + 1];
		Arrays.fill(fare, Integer.MAX_VALUE);
		fare[start] = 0;

		PriorityQueue<Bus> queue = new PriorityQueue<>((a, b) -> Integer.compare(a.fare, b.fare));
		queue.add(new Bus(start, 0));
		while (!queue.isEmpty()) {
			Bus current = queue.poll();

			if (current.fare > fare[current.arrival]) {
				continue;
			}

			for (Bus bus : busRoute.get(current.arrival)) {
				int newFare = current.fare + bus.fare;

				if (newFare < fare[bus.arrival]) {
					fare[bus.arrival] = newFare;
					queue.add(new Bus(bus.arrival, newFare));
				}
			}
		}

		return fare[destination];
	}

	static class Bus {
		int arrival;
		int fare;

		Bus(int arrival, int fare) {
			this.arrival = arrival;
			this.fare = fare;
		}
	}
}