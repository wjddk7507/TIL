import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_햄버거다이어트 {
	static int N, L, result;
	static int[][] ingredients;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			ingredients = new int[N][2];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				ingredients[i][0] = Integer.parseInt(st.nextToken());
				ingredients[i][1] = Integer.parseInt(st.nextToken());
			}
			
			result = 0;
			combi(0, 0, 0);
			
			System.out.println("#"+t+" "+result);
		}
	}
	
	public static void combi(int cnt, int score, int calorie) {
		if(cnt == N) {
			if(calorie <= L) result = Math.max(result, score);
			return;
		}
		
		combi(cnt+1, score+ingredients[cnt][0], calorie+ingredients[cnt][1]);
		combi(cnt+1, score, calorie);
	}
}
