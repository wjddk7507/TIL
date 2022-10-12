import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_사랑의카운슬러 {
	static int N, sumX, sumY;
	static long min;
	static int[][] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			sumX = sumY = 0;
			arr = new int[N][2];
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
				sumX += arr[i][0];
				sumY += arr[i][1];
			}
			
			min = Long.MAX_VALUE;
			// 움직일 지렁이 선택
			combi(0, 0, new int[N/2]);
			System.out.println("#"+t+" "+min);
		}
	}
	
	public static void combi(int start, int cnt, int[] selected) {
		if(cnt == N/2) {
			int selectedSumX = 0;
			int selectedSumY = 0;
			for(int i = 0; i < N/2; i++) {
				selectedSumX += arr[selected[i]][0];
				selectedSumY += arr[selected[i]][1];
			}
			int unSelectedSumX = sumX - selectedSumX;
			int unSelectedSumY = sumY - selectedSumY;
			
			long tx = selectedSumX - unSelectedSumX;
			long ty = selectedSumY - unSelectedSumY;
			long sum = tx*tx+ty*ty;
			min = Math.min(min, sum);
			return;
		}
		
		for(int i = start; i < N; i++) {
			selected[cnt] = i;
			combi(i+1, cnt+1, selected);
		}
	}
}
