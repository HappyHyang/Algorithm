import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {
        StringTokenizer tokens = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(tokens.nextToken());
        int K = Integer.parseInt(tokens.nextToken());
        
        int[] values = new int[N];
        for(int n = 0; n < N; n++) {
            values[n] = Integer.parseInt(input.readLine());
        }
        
        int total = 0;
        
        for(int i = N - 1; i >= 0; i--) {
            if (values[i] <= K) {
                int cnt = K / values[i];
                K -= cnt * values[i];
                total += cnt;
            }
        }
        System.out.print(total);
    }
}