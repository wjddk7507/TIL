import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_요리사 {
	static int N, taste;
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// N개 중 N/2개 선택해서 맛 계산하기
			taste = Integer.MAX_VALUE;
			combi(0, 0, N/2, new boolean[N]);
			
			System.out.println("#"+t+" "+taste);
		}
	}
	
	public static void combi(int start, int cnt, int end, boolean[] selected) {
		if(cnt == end) {
			List<Integer> aList = new ArrayList<>();
			List<Integer> bList = new ArrayList<>();
			for(int i = 0; i < N; i++) {
				if(selected[i]) aList.add(i);
				else bList.add(i);
			}
			// A 맛 계산
			int A = 0;
			for(int i = 0; i < aList.size(); i++) {
				for(int j = 0; j < aList.size(); j++) {
					A += map[aList.get(i)][aList.get(j)];
				}
			}
			// B 맛 계산
			int B = 0;
			for(int i = 0; i < bList.size(); i++) {
				for(int j = 0; j < bList.size(); j++) {
					B += map[bList.get(i)][bList.get(j)];
				}
			}
			taste = Math.min(taste, Math.abs(A-B));
			return;
		}
		
		for(int i = start; i < N; i++) {
			if(selected[i]) continue;
			selected[i] = true;
			combi(i+1, cnt+1, end, selected);
			selected[i] = false;
		}
	}
}
