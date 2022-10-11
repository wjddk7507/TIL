import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_규영이와인영이의카드게임 {
	static int N, win, lose;
	static int[] gyu, in, cur;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		N = 9;
		for(int t = 1; t <= T; t++) {
			boolean[] card = new boolean[18];
			gyu = new int[N];
			in = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 9; i++) {
				gyu[i] = Integer.parseInt(st.nextToken());
				card[gyu[i]-1] = true;
			}
			int idx = 0;
			for(int i = 0; i < 18; i++) {
				if(!card[i]) in[idx++] = i+1;
			}
			
			// 카드배틀~
			win = 0;
			lose = 0;
			cur = new int[N];
			perm(0, new boolean[N]);
			
			
			System.out.println("#"+t+" "+lose+" "+win);
		}
	}
	
	public static void perm(int cnt, boolean[] isSelected) {
		if(cnt == N) {
			int gScore = 0;
			int iScore = 0;
			for(int i = 0; i < N; i++) {
				if(gyu[i] > cur[i]) gScore += gyu[i]+cur[i];
				else if(cur[i] > gyu[i]) iScore += gyu[i]+cur[i];
			}
			if(iScore > gScore) win++;
			else lose++;
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(isSelected[i]) continue;
			isSelected[i] = true;
			cur[cnt] = in[i];
			perm(cnt+1, isSelected);
			isSelected[i] = false;
		}
		
	}
}
