import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_사칙연산유효성검사 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		for(int t = 1; t <= T; t++) {
			boolean isAvailable = true;
			int N = Integer.parseInt(br.readLine());
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String[] arr = new String[4];
				int n = 0;
				while(st.hasMoreTokens()) {
					arr[n++] = st.nextToken();
				}
				
				if("0123456789".contains(arr[1])) {
					// 숫자 노드인 경우 자식 노드가 없어야 함
					if(arr[2]!=null || arr[3]!=null) isAvailable = false;
				} else if("+-*/".contains(arr[1])) {
					// 연산자인 경우 자식 노드가 필요
					if(arr[2]==null || arr[3]==null) isAvailable = false;
				}
			}
			
			System.out.println("#"+t+" "+(isAvailable?1:0));
		}
	}
}
