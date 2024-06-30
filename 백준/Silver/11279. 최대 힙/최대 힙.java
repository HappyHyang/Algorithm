import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(input.readLine());
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		for (int n = 0; n < N; n++) {
			int num = Integer.parseInt(input.readLine());
			if (num == 0) {
				output.append(maxHeap.isEmpty() ? 0 : maxHeap.poll()).append("\n");
			} else {
				maxHeap.add(num);
			}
		}
		System.out.print(output);
	}
}