import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();

	// input: N(지도의 크기), MAP(지도)
	static int N, MAP[][];
	// output: cntHouse(각 단지에 속하는 집의 수)
	static ArrayList<Integer> cntApt = new ArrayList<>();
	
	static int cnt;
	static boolean visited[][];
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception {
		// input
		N = Integer.parseInt(input.readLine());
		
		MAP = new int[N][N];
		for (int row = 0; row < N; row++) {
			String line = input.readLine();
			for (int col = 0; col < N; col++) {
				MAP[row][col] = line.charAt(col) - '0';
			}
		}
		
		visited = new boolean[N][N];
		for(int row = 0; row < N; row++) {
			for(int col = 0; col < N; col++) {
				if(isNewApt(row, col)) {
					cnt = 1;
					solution(row, col);
					cntApt.add(cnt);
				}
			}
		}
		Collections.sort(cntApt);
		
		// output
		output.append(cntApt.size()).append("\n");
		for(int cnt:cntApt) {
			output.append(cnt).append("\n");
		}
		System.out.println(output);
	}
	
	public static void solution(int r, int c) {
		visited[r][c] = true;
		
		for(int d = 0; d < 4; d++) {
			int x = r + dx[d];
			int y = c + dy[d];
			if(isIn(x, y) && isNewApt(x, y)) {
				solution(x, y);
				cnt++;
			}
		}
	}
	
	public static boolean isIn(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}
	
	public static boolean isNewApt(int x, int y) {
		return MAP[x][y] == 1 && !visited[x][y];
	}
}