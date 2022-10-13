import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_14502_연구소 {
	static int N, M, W, answer;
	static int[][] map;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static List<int[]> list;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		W = 3;
		map = new int[N][M];
		list = new ArrayList<>(); // 벽 세울 수 있는 곳 저장
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) list.add(new int[] {i, j});
			}
		}
		
		answer = 0;
		// 벽 3개 세우기
		combi(0, 0, new int[W]);
		System.out.println(answer);
	}
	
	public static void combi(int start, int cnt, int[] walls) {
		if(cnt == W) {
			// 벽 설치
			int[][] safe = new int[N][M];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					safe[i][j] = map[i][j];
				}
			}
			
			setWall(safe, walls);
			// 바이러스 퍼짐
			virus(safe);
			// 안전영역 수 구하기
			answer = Math.max(answer, getSafeArea(safe));
			return;
		}
		
		for(int i = start; i < list.size(); i++) {
			walls[cnt] = i;
			combi(i+1, cnt+1, walls);
		}
	}
	
	// 벽 설치
	public static void setWall(int[][] safe, int[] walls) {
		for(int w = 0; w < walls.length; w++) {
			int[] pos = list.get(walls[w]);
			safe[pos[0]][pos[1]] = 1;
		}
	}
	
	public static void virus(int[][] safe) {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(safe[i][j] == 2) {
					safe[i][j] = 3;
					spreadVirus(i, j, safe);
				}
			}
		}
	}
	
	public static void spreadVirus(int r, int c, int[][] safe) {
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr<0 || nc<0 || nr>=N || nc>=M) continue;
			if(safe[nr][nc] == 0) {
				safe[nr][nc] = 3;
				spreadVirus(nr, nc, safe);
			}
		}
	}

	// 안전 영역 크기 구하기
	public static int getSafeArea(int[][] safe) {
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(safe[i][j] == 0) cnt++;
			}
		}
		return cnt;
	}

}
