import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_14501_퇴사 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		int[] dp = new int[N+1];
		for(int i = N-1; i >= 0; i--) {
			if(i+arr[i][0] > N) {
				dp[i] = dp[i+1];
			} else {
				dp[i] = Math.max(dp[i+1], arr[i][1]+dp[i+arr[i][0]]);
			}
		}
		
		System.out.println(dp[0]);
	}
}
