import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_스도쿠검증 {
	static int[][] map;
	static int N;
	static boolean isPossible;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		N = 9;
		for(int t = 1; t <= T; t++) {
			map = new int[N][N];
			isPossible = true;
			// 입력
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for(int i = 0; i < N; i++) {
				boolean[] colNum = new boolean[N];
				boolean[] rowNum = new boolean[N];
				// 가로, 세로 검증
				for(int j = 0; j < N; j++) {
					colNum[map[i][j]-1] = true;
					rowNum[map[j][i]-1] = true;
				}
				if(!checkNum(colNum) || !checkNum(rowNum)) isPossible = false;
			}
			
			// 3x3 검증
			if(isPossible) {
				for(int i = 0; i < N; i+=3) {
					for(int j = 0; j < N; j+=3) {
						boolean[] num = new boolean[N];
						for(int x = i; x < i+3; x++) {
							for(int y = j; y < j+3; y++) {
								num[map[x][y]-1] = true;
							}
						}
						if(!checkNum(num)) isPossible = false;
					}
					if(!isPossible) break;
				}
			}
			System.out.println("#"+t+" "+(isPossible?1:0));
		}
	}
	
	public static boolean checkNum(boolean[] arr) {
		boolean isTrue = true;
		for(int i = 0; i < N; i++) {
			if(!arr[i]) {
				isTrue = false;
				break;
			}
		}
		return isTrue;
	}
}
