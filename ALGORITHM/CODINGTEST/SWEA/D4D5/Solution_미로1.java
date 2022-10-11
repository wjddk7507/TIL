import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_미로1 {
	static int[][] map;
	static boolean[][] visited;
	static int N;
	static boolean isPossible;
	static int[] dr = {0, 1, 0, -1}; // 우하좌상
	static int[] dc = {1, 0, -1, 0};
	
	public static void main(String[] args) throws Exception {
		N = 16;
		int T = 10;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t = 1; t <= T; t++) {
			int tc = Integer.parseInt(br.readLine());
			isPossible = false;
			map = new int[N][N];
			visited = new boolean[N][N];
			int sr = 0, sc = 0, er = 0, ec = 0;
			for(int i = 0; i < N; i++) {
				char[] chars = br.readLine().toCharArray();
				for(int j = 0; j < N; j++) {
					map[i][j] = chars[j]-'0';
					if(map[i][j] == 1) {
						visited[i][j] = true;
					} else if(map[i][j] == 2) {
						sr = i;
						sc = j;
					} else if(map[i][j] == 3) {
						er = i;
						ec = j;
					}
				}
			}
			dfs(sr, sc, er, ec);
			System.out.println("#"+t+" "+(isPossible?1:0));
		}
		
	}
	
	public static void dfs(int r, int c, int er, int ec) {
		if(r == er && c == ec) {
			isPossible = true;
			return;
		}
		
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr<0 || nc<0 || nr>=N || nc>=N) continue;
			if(visited[nr][nc]) continue;
			visited[nr][nc] = true;
			dfs(nr, nc, er, ec);
			visited[nr][nc] = false;
		}
	}
}
