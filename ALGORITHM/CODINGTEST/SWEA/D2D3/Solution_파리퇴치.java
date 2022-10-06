import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_파리퇴치 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			System.out.println("#"+t+" "+catchFly(M, map));
		}
	}
	
	public static int catchFly(int m, int[][] map) {
		int max = 0;
		
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map.length; j++) {
				int cnt = 0;
				for(int x = i; x < i+m && x < map.length; x++) {
					for(int y = j; y < j+m && y < map.length; y++) {
						cnt += map[x][y];
					}
				}
				max = Math.max(max, cnt);
			}
		}
		return max;
	}

}
