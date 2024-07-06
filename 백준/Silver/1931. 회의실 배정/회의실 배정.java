import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Meeting implements Comparable<Meeting> {
		int start;
		int end;

		Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Meeting o) {
			if (this.end == o.end) {
				return Integer.compare(this.start, o.start);
			}
			return Integer.compare(this.end, o.end);
		}
	}

	static int N;
	static Meeting[] meetings;

	public static void main(String[] args) throws IOException {
		initialize();
		System.out.println(solution());
	}

	static void initialize() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(input.readLine());
		meetings = new Meeting[N];
		for (int n = 0; n < N; n++) {
			StringTokenizer tokens = new StringTokenizer(input.readLine());
			int start = Integer.parseInt(tokens.nextToken());
			int end = Integer.parseInt(tokens.nextToken());
			meetings[n] = new Meeting(start, end);
		}
	}

	static int solution() {
		Arrays.sort(meetings);
		int cnt = 1;
		int lastEnd = meetings[0].end;
		for (int n = 1; n < N; n++) {
			if (meetings[n].start >= lastEnd) {
				cnt++;
				lastEnd = meetings[n].end;
			}
		}
		return cnt;
	}
}