\import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_상호의배틀필드 {

	public static void main(String[] args) throws Exception {
		// 방향 상하좌우
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		char[] dChar = {'^', 'v', '<', '>'};
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			char[][] map = new char[N][M];
			int r = 0, c = 0, dir = 0;	
			for(int i = 0; i < N; i++) {
				char[] chars = br.readLine().toCharArray();
				for(int j = 0; j < M; j++) {
					map[i][j] = chars[j];
					if(chars[j]=='<' || chars[j]=='>' || chars[j]=='^' || chars[j]=='v') {
						r = i;
						c = j;
					}
				}
			}
			
			if(map[r][c] == '^') dir = 0;
			else if(map[r][c] == 'v') dir = 1;
			else if(map[r][c] == '<') dir = 2;
			else if(map[r][c] == '>') dir = 3;
			map[r][c] = '.';
			
			br.readLine();
			char[] command = br.readLine().toCharArray();
			for(int i = 0; i < command.length; i++) {
				if(command[i] == 'U') dir = 0;
				else if(command[i] == 'D') dir = 1;
				else if(command[i] == 'L') dir = 2;
				else if(command[i] == 'R') dir = 3;
				// 방향전환
				int nr = r+dr[dir];
				int nc = c+dc[dir];
				if(nr<0 || nc<0 || nr>=N || nc>=M) continue;

				if(command[i] == 'S') {
					while(true) {
						if(nr<0 || nc<0 || nr>=N || nc>=M || map[nr][nc] == '#') break;
						else if(map[nr][nc] == '.' || map[nr][nc] == '-') {
							nr += dr[dir];
							nc += dc[dir];
						} else if(map[nr][nc] == '*') {
							map[nr][nc] = '.';
							break;
						}
					}
					continue;
				}
				
				if(map[nr][nc]=='.') {
					r = nr;
					c = nc;
				}
			}
			
			map[r][c] = dChar[dir];
			
			// 출력
			System.out.print("#"+t+" ");
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}
}
