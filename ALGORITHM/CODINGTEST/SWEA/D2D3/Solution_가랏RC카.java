import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_가랏RC카 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int distance = 0;
			int speed = 0;
			
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int command = Integer.parseInt(st.nextToken());
				
				if(command == 1){
					speed += Integer.parseInt(st.nextToken());
				} else if(command == 2) {
					speed -= Integer.parseInt(st.nextToken());
					if(speed < 0) speed = 0;
				}
				
				distance += speed;
			}
			
			System.out.println("#"+t+" "+distance);
		}
	}
}
