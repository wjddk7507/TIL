import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14889_스타트와링크 {
	static int N, min;
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		min = Integer.MAX_VALUE;
		combi(0, 0, new boolean[N]);
		System.out.println(min);
	}
	
	public static void combi(int cnt, int start, boolean[] selected) {
		if(cnt == N/2) {
			// 팀 나누기
			int[] teamS = new int[N/2];
			int[] teamL = new int[N/2];
			int idxS = 0;
			int idxL = 0;
			for(int i = 0; i < N; i++) {
				if(selected[i]) teamS[idxS++] = i;
				else teamL[idxL++] = i;
			}
			
			// 점수 계산
			int scoreS = 0;
			int scoreL = 0;
			for(int i = 0; i < N/2-1; i++) {
				for(int j = i+1; j < N/2; j++) {
					scoreS += map[teamS[i]][teamS[j]]+map[teamS[j]][teamS[i]];
					scoreL += map[teamL[i]][teamL[j]]+map[teamL[j]][teamL[i]];
				}
			}
			min = Math.min(min, Math.abs(scoreS-scoreL));
			return;
		}
		
		for(int i = start; i < N; i++) {
			selected[i] = true;
			combi(cnt+1, i+1, selected);
			selected[i] = false;
		}
	}
}
