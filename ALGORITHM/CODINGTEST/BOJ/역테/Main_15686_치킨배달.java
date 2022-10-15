import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_15686_치킨배달 {
	public static int N, M, min;
	public static int[][] map, distMap;
	public static List<int[]> home;
	public static List<int[]> chicken;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		home = new ArrayList<>();
		chicken = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) home.add(new int[] {i, j});
				else if(map[i][j] == 2) chicken.add(new int[] {i, j});
			}
		}
		
		distMap = new int[home.size()][chicken.size()];
		for(int i = 0; i < home.size(); i++) {
			for(int j = 0; j < chicken.size(); j++) {
				distMap[i][j] = Math.abs(home.get(i)[0]-chicken.get(j)[0]) + Math.abs(home.get(i)[1]-chicken.get(j)[1]);
			}
		}
		
		min = Integer.MAX_VALUE;
		combi(0, 0, new int[M]);
		System.out.println(min);
	}
	
	public static void combi(int start, int cnt, int[] arr) {
		if(cnt == M) {
			int tot = 0;
			for(int i = 0; i < home.size(); i++) {
				int minDist = Integer.MAX_VALUE;
				for(int j = 0; j < M; j++) {
					minDist = Math.min(minDist, distMap[i][arr[j]]);
				}
				tot += minDist;
			}
			min = Math.min(min, tot);
			return;
		}
		
		for(int i = start; i < chicken.size(); i++) {
			arr[cnt] = i;
			combi(i+1, cnt+1, arr);
		}
		
	}
	
}
