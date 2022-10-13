import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14888_연산자끼워넣기 {
	static int N, min, max;
	static int[] num, operator;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		num = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) num[i] = Integer.parseInt(st.nextToken());
		
		operator = new int[4];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) operator[i] = Integer.parseInt(st.nextToken());
		
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		cal(1, num[0]);
		System.out.println(max);
		System.out.println(min);
	}

	public static void cal(int cnt, int total) {
		if(cnt == N) {
			min = Math.min(min, total);
			max = Math.max(max, total);
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			if(operator[i] > 0) {
				operator[i]--;
				if(i == 0) {
					cal(cnt+1, total+num[cnt]);
				} else if(i == 1) {
					cal(cnt+1, total-num[cnt]);
				} else if(i == 2) {
					cal(cnt+1, total*num[cnt]);
				} else {
					cal(cnt+1, total/num[cnt]);
				}
				operator[i]++;
			}
		}
	}
}
