import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens = null;

    public static void main(String[] args) throws Exception {
        tokens = new StringTokenizer(input.readLine(), " ");
        System.out.println(tokens.countTokens());
    }
}