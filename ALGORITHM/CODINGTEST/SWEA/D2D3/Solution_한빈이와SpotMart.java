import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_한빈이와SpotMart {
	static int N, M, max;
	static int[] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			max = -1;
			pick(0, 0, 0);
			System.out.println("#"+t+" "+max);
		}
	}
	
	public static void pick(int cnt, int start, int tot) {
		if(cnt == 2) {
			max = Math.max(max, tot);
			return;
		}
		
		for(int i = start; i < N; i++) {
			if(tot+arr[i] > M) continue;
			pick(cnt+1, i+1, tot+arr[i]);
		}
	}
}
