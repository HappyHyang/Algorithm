import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int col = sc.nextInt();
        int row = sc.nextInt();
        
        StringBuilder answer = new StringBuilder();
        for (int r = 0; r < row; r++) {
            answer.append("*".repeat(col)).append('\n');
        }
        System.out.println(answer.toString());
    }
}