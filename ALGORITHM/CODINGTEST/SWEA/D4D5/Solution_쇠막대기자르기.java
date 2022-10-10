import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_쇠막대기자르기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			int cnt = 0;
			Stack<Character> stack = new Stack<>();
			String str = br.readLine();
			for(int i = 0; i < str.length(); i++) {
				if(str.charAt(i) == '(') {
					if(i+1 < str.length() && str.charAt(i+1) == ')') {
						cnt += stack.size();
						i++;
					} else stack.add('(');
					
				} else {
					stack.pop();
					cnt++;
				}
			}
			
			System.out.println("#"+t+" "+cnt);
		}
	}
}
