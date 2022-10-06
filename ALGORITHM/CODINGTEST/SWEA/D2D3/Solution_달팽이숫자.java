import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_달팽이숫자 {

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			
			// 달팽이 숫자 만들기 // dir 0:우, 1:하, 2:좌, 3:상
			int num = 1, r = 0, c = 0, dir = 0;
			map[0][0] = num++;
			while(num <= N*N) {
				if(dir == 0 && c+1 < N && map[r][c+1] == 0) {
					c++;
				} else if(dir == 1 && r+1 < N && map[r+1][c] == 0) {
					r++;
				} else if(dir == 2 && c-1 >= 0 && map[r][c-1] == 0) {
					c--;
				} else if(dir == 3 && r-1 >= 0 && map[r-1][c] == 0) {
					r--;
				} else {
					dir = (dir+1)%4;
					continue;
				}
				map[r][c] = num++;
			}
			
			// 출력
			System.out.println("#"+t);
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
		}
	}
}
