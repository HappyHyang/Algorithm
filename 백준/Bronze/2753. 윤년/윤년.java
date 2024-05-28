import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	static int YEAR;

	public static void main(String[] args) throws Exception {
		YEAR = Integer.parseInt(input.readLine());
		System.out.println(isLeapYear(YEAR) ? 1 : 0);
	}

	static Boolean isLeapYear(int year) {
		return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
	}
}