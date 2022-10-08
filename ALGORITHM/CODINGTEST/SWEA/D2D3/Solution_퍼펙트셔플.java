import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_퍼펙트셔플 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			String[] arr = new String[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				arr[i] = st.nextToken();
			}
			
			int d = 0;
			int len = 0;
			if(N%2==0) {
				d = N/2;
				len = N/2;
			} else {
				d = (int)Math.floor(N/2)+1;
				len = N/2+1;
			}
			// 출력
			System.out.print("#"+t+" ");
			for(int i = 0; i < len; i++) {
				System.out.print(arr[i]+" ");
				if(d+i < N) System.out.print(arr[d+i]+" ");
			}
			System.out.println();
		}
	}
}
