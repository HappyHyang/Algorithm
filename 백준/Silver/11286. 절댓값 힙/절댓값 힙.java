import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(input.readLine());

		StringBuilder output = new StringBuilder();
		PriorityQueue<Integer> absoluteHeap = new PriorityQueue<>(
			Comparator.comparingInt((Integer o) -> Math.abs(o)).thenComparingInt(o -> o));
		for (int n = 0; n < N; n++) {
			int num = Integer.parseInt(input.readLine());
			if (num == 0) {
				output.append(absoluteHeap.isEmpty() ? 0 : absoluteHeap.poll()).append('\n');
			} else {
				absoluteHeap.add(num);
			}
		}
		System.out.println(output);
	}
}