import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String auditoriumUser = "";
		int maxAttendance = 0;
		for (int i = 0; i < 7; i++) {
			StringTokenizer tokenizer = new StringTokenizer(input.readLine());
			String seminar = tokenizer.nextToken();
			int attendance = Integer.parseInt(tokenizer.nextToken());
			if (attendance > maxAttendance) {
				maxAttendance = attendance;
				auditoriumUser = seminar;
			}
		}
		System.out.println(auditoriumUser);
	}
}