import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_비밀번호 {
	public static void main(String[] args) throws Exception {
		int T = 10;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			String str = st.nextToken();
			Stack<Character> stack = new Stack<>();
			for(int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if(!stack.isEmpty() && stack.peek() == c) {
					stack.pop();
				} else {
					stack.push(c);
				}
			}
			System.out.print("#"+t+" ");
			for(char c : stack) System.out.print(c);
			System.out.println();
		}
	}
}
