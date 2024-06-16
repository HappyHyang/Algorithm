import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        StringTokenizer tokens = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(tokens.nextToken());
        int M = Integer.parseInt(tokens.nextToken());

        HashMap<Integer, String> numToName = new HashMap<>();
        HashMap<String, Integer> nameToNum = new HashMap<>();

        for (int n = 1; n <= N; n++) {
            String pokemon = input.readLine().trim();
            numToName.put(n, pokemon);
            nameToNum.put(pokemon, n);
        }

        for (int m = 0; m < M; m++) {
            String question = input.readLine().trim();
            if (Character.isDigit(question.charAt(0))) {
                output.append(numToName.get(Integer.parseInt(question))).append("\n");
            } else {
                output.append(nameToNum.get(question)).append("\n");
            }
        }
        System.out.print(output);
    }
}