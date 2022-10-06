import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_농작물수확하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] farm = new int[N][N];
			for(int i = 0; i < N; i++) {
				char[] chars = br.readLine().toCharArray();
				for(int j = 0; j < N; j++) {
					farm[i][j] = chars[j]-'0';
				}
			}
			
			int sum = 0;
			for(int i = 0; i < N; i++) {
				int start = Math.abs(i-N/2);
				for(int j = start; j < N-start; j++) {
					sum += farm[i][j];
				}
			}
			
			System.out.println("#"+t+" "+sum);
		}
	}

}
