import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static class Body {
		int weight;
		int height;

		Body(int weight, int height) {
			this.weight = weight;
			this.height = height;
		}
	}

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens = null;

	static int N;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());

		Body[] bodies = new Body[N];
		for (int n = 0; n < N; n++) {
			tokens = new StringTokenizer(input.readLine());
			int weight = Integer.parseInt(tokens.nextToken());
			int height = Integer.parseInt(tokens.nextToken());
			bodies[n] = new Body(weight, height);
		}

		for (int i = 0; i < bodies.length; i++) {
			int cnt = 1;
			for (int j = 0; j < bodies.length; j++) {
				if (i != j && bodies[j].height > bodies[i].height && bodies[j].weight > bodies[i].weight) {
					cnt++;
				}
			}
			output.append(cnt).append(" ");
		}

		System.out.print(output.toString().trim());
	}
}