import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();

		int N = Integer.parseInt(input.readLine());
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		for (int n = 0; n < N; n++) {
			int num = Integer.parseInt(input.readLine());
			if (num == 0) {
				if (!minHeap.isEmpty()) {
					output.append(minHeap.poll() + "\n");
				} else {
					output.append(0 + "\n");
				}
			} else {
				minHeap.add(num);
			}
		}
		System.out.print(output);
	}
}