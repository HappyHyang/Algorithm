import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		String[] balances = input.readLine().split(" ");
		int balance = Integer.parseInt(balances[0]) + Integer.parseInt(balances[1]);
		int chickenCost = Integer.parseInt(input.readLine()) * 2;

		if (balance >= chickenCost) {
			System.out.println(balance - chickenCost);
		} else {
			System.out.println(balance);
		}
	}
}