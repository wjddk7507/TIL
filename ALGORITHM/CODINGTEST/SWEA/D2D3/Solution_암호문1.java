import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_암호문1 {
	public static void main(String[] args) throws Exception {
		int T = 10;
		int len = 10;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			String[] original = new String[10];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < len; i++) original[i] = st.nextToken();
			String[] copy = original.clone();
			
			int I = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), "I");
			for(int i = 0; i < I; i++) {
				String command = st.nextToken().trim();
				String[] arr = command.split(" ");
				int index = Integer.parseInt(arr[0]);
				int count = Integer.parseInt(arr[1]);
				
				for(int j = 0; j < count; j++) {
					if(j+index >= len) break;
					copy[j+index] = arr[2+j];
				}
				for(int j = index+count; j < len; j++) {
					copy[j] = original[j-count];
				}
				original = copy.clone();
			}
			System.out.print("#"+t+" ");
			for(int i = 0; i < len; i++) System.out.print(original[i]+" ");
			System.out.println();
		}
	}
}
