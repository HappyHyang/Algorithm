import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int[] parent;

	public static void main(String[] args) throws IOException {
		System.out.println(joinParty());
	}

	static int joinParty() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(input.readLine());
		int N = Integer.parseInt(tokenizer.nextToken()); // 사람의 수
		int M = Integer.parseInt(tokenizer.nextToken()); // 파티의 수

		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		tokenizer = new StringTokenizer(input.readLine());
		int cntTruth = Integer.parseInt(tokenizer.nextToken()); // 진실을 아는 사람의 수
		if (cntTruth == 0) {
			return M;
		}
		int[] knowTruth = new int[cntTruth]; // 진실을 아는 사람들의 번호
		for (int i = 0; i < knowTruth.length; i++) {
			knowTruth[i] = Integer.parseInt(tokenizer.nextToken());
		}

		ArrayList<Integer>[] parties = new ArrayList[M];
		for (int i = 0; i < M; i++) {
			parties[i] = new ArrayList<>();
			tokenizer = new StringTokenizer(input.readLine());
			int cntParticipant = Integer.parseInt(tokenizer.nextToken()); // 파티 참여자 수
			int firstPerson = Integer.parseInt(tokenizer.nextToken());
			parties[i].add(firstPerson);

			for (int j = 1; j < cntParticipant; j++) {
				int person = Integer.parseInt(tokenizer.nextToken());
				parties[i].add(person);
				union(firstPerson, person);
			}

		}

		for (int i = 1; i < knowTruth.length; i++) {
			union(knowTruth[0], knowTruth[i]);
		}

		int result = 0;

		for (ArrayList<Integer> party : parties) {
			boolean canLie = true;
			for (int person : party) {
				if (find(person) == find(knowTruth[0])) {
					canLie = false;
					break;
				}
			}
			if (canLie) {
				result++;
			}
		}

		return result;
	}

	static int find(int x) {
		if (x == parent[x]) {
			return x;
		} else {
			return parent[x] = find(parent[x]);
		}
	}

	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x != y) {
			parent[y] = x;
		}
	}

}