import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_정사각형방 {
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int N, max, index;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visited = new boolean[N][N];
			max = 0;
			index = Integer.MAX_VALUE;
			
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					int n = dfs(0, i, j);
					if(max < n) {
						max = n;
						index = map[i][j];
					} else if(max == n) {
						index = Math.min(index, map[i][j]);
					}
				}
			}
			
			// 출력
			System.out.println("#"+t+" "+index+" "+(max+1));
			
		}
	}
	
	public static int dfs(int cnt, int r, int c) {
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr<0 || nc<0 || nr>=N || nc>= N) continue;
			if(visited[nr][nc]) continue;
			if(map[nr][nc]-map[r][c] == 1) {
				return dfs(cnt+1, nr, nc);
			}
		}
		return cnt;
	}
	
}
