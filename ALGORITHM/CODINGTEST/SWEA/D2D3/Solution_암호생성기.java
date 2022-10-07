import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_암호생성기 {

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		int N = 8;
		for(int t = 1; t <= T; t++) {
			br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[N];
			for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

			int idx = 0;
			int n = 1;
			
			while(true) {
				arr[idx] -= n;
				if(arr[idx] <= 0) {
					arr[idx] = 0;
					break;
				}
				n = n%5+1;
				idx = (idx+1)%N;
			}
			
			// 출력
			System.out.print("#"+t+" ");
			for(int i = 0; i < N; i++) System.out.print(arr[(idx+i+1)%N]+" ");
			System.out.println();
			
		}
	}
}
