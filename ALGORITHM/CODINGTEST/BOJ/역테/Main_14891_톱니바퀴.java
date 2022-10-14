import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14891_톱니바퀴 {
	// 맞물리는 곳 index
	static int N = 4, M = 8, right = 2, left = 6;
	static int[][] gear;
	
	public static void main(String[] args) throws Exception {
		gear = new int[N][M];
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i < N; i++) {
			char[] chars = br.readLine().toCharArray();
			for(int j = 0; j < M; j++) gear[i][j] = chars[j]-'0';
		}
		
		int K = Integer.parseInt(br.readLine());
		for(int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int index = Integer.parseInt(st.nextToken())-1;
			int dir = Integer.parseInt(st.nextToken());
			move(index, dir);
		}
		
		
		int sum = 0;
		for(int i = 0; i < N; i++) {
			if(gear[i][0] == 1) sum += Math.pow(2, i);
		}
		System.out.println(sum);
	}
	
	// 회전하기 => 1: 시계방향, -1: 반시계방향
	public static void move(int index, int clockWise) {
		
		// 왼쪽으로 돌릴 수 있는 index
		int idxL = index;
		while(idxL-1 >= 0) {
			if(gear[idxL][left] != gear[idxL-1][right]) idxL--;
			else break;
		}
		
		// 오른쪽으로 돌릴 수 있는 index
		int idxR = index;
		while(idxR+1 < N) {
			if(gear[idxR][right] != gear[idxR+1][left]) idxR++;
			else break;
		}
		// 나 돌리기
		rotate(index, clockWise);

		if(clockWise == 1) {
			int tempC = clockWise;
			// 왼쪽 돌리기
			for(int i = index-1; i >= idxL; i--) {
				tempC *= -1;
				rotate(i, tempC);
			}
			// 오른쪽 돌리기
			tempC = clockWise;
			for(int i = index+1; i <= idxR; i++) {
				tempC *= -1;
				rotate(i, tempC);
			}
		} else {
			int tempC = clockWise;
			// 왼쪽 돌리기
			for(int i = index-1; i >= idxL; i--) {
				tempC *= -1;
				rotate(i, tempC);
			}
			// 오른쪽 돌리기
			tempC = clockWise;
			for(int i = index+1; i <= idxR; i++) {
				tempC *= -1;
				rotate(i, tempC);
			}
		}
	}
	
	public static void rotate(int index, int dir) {
		if(dir == 1) {
			int temp = gear[index][M-1];
			for(int i = M-2; i >= 0; i--) {
				gear[index][i+1] = gear[index][i];
			}
			gear[index][0] = temp;
		} else {
			int temp = gear[index][0];
			for(int i = 1; i < M; i++) {
				gear[index][i-1] = gear[index][i];
			}
			gear[index][M-1] = temp;
			
		}
	}
	

}
