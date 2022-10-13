import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14503_로봇청소기 {
	static int N, M, answer;
	static int[][] map;
	static boolean[][] visited;
	// 0북 1동 2남 3서
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int dir = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		answer = 1;
		clean(r, c, dir);
		System.out.println(answer);
	}
	
	public static void clean(int r, int c, int dir) {
		// 현재 위치 청소
		visited[r][c] = true;
		
		for(int d = 0; d < 4; d++) {
			// 다음 방향은 (4-d)%4
			dir = (dir+3)%4;
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			
			if(checkRange(nr, nc) && map[nr][nc] == 0 && !visited[nr][nc]) {
				// 왼쪽 방향 청소 가능
				answer++;
				clean(nr, nc, dir);
				return;
			} 
		}
		
		// 청소할 곳이 없는 경우 - 방향 유지, 한 칸 뒤로
		int bd = (dir+2)%4;
		int br = r+dr[bd];
		int bc = c+dc[bd];
		if(checkRange(br, bc) && map[br][bc] != 1) clean(br, bc, dir);
		
	}
	
	public static boolean checkRange(int r, int c) {
		if(r<0 || c<0 || r>=N || c>=M) return false;
		else return true;
	}

}
