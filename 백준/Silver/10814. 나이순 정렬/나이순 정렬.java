import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static class Member {
		int id;
		int age;
		String name;

		Member(int id, int age, String name) {
			this.id = id;
			this.age = age;
			this.name = name;
		}
	}

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens = null;

	static int N;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());
		Member[] members = new Member[N];
		for (int n = 0; n < N; n++) {
			tokens = new StringTokenizer(input.readLine());
			members[n] = new Member(n, Integer.parseInt(tokens.nextToken()), tokens.nextToken());
		}
		Arrays.sort(members, new Comparator<Member>() {
			@Override
			public int compare(Member o1, Member o2) {
				if (o1.age == o2.age) {
					return Integer.compare(o1.id, o2.id);
				} else {
					return Integer.compare(o1.age, o2.age);
				}
			}
		});

		for (Member member : members) {
			output.append(member.age).append(" ").append(member.name).append("\n");
		}
		System.out.print(output);
	}
}