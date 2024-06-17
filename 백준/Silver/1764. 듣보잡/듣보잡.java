import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Collections;

class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        StringTokenizer tokens = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(tokens.nextToken());
        int M = Integer.parseInt(tokens.nextToken());
        
        Set<String> noListen = new HashSet<>();
        for(int n = 0; n < N; n++) {
            noListen.add(input.readLine());
        }
        
        Set<String> noSee = new HashSet<>();
        for(int m = 0; m < M; m++) {
            noSee.add(input.readLine());
        }
        
        noListen.retainAll(noSee);
        List<String> answer = new ArrayList<>(noListen);
        Collections.sort(answer);
        output.append(answer.size()).append("\n");
        for(String name : answer) {
            output.append(name).append("\n");
        }
        System.out.print(output);
    }
}