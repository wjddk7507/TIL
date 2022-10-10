import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_부서진타일 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			char[][] arr = new char[N][M];
			for(int i = 0; i < N; i++) {
				arr[i] = br.readLine().toCharArray();
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(arr[i][j] == '#' && i+1 < N && j+1 < M) {
						if(arr[i+1][j] == '#' && arr[i][j+1] == '#' && arr[i+1][j+1] == '#') {
							arr[i][j] = '.';
							arr[i+1][j] = '.';
							arr[i][j+1] = '.';
							arr[i+1][j+1] = '.';
						}
					}
				}
			}
			
			boolean isAvailable = true;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(arr[i][j] == '#') {
						isAvailable = false;
						break;
					}
				}
				if(!isAvailable) break;
			}
			
			System.out.println("#"+t+" "+(isAvailable?"YES":"NO"));
		}
	}
}
