import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_괄호짝짓기 {

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			String str = br.readLine();
			Stack<Character> stack = new Stack<>();
			int isAvailable = 1;
			for(int i = 0; i < N; i++) {
				char c = str.charAt(i);
				if("({[<".contains(String.valueOf(c))) {
					stack.add(c);
				} else {
					char temp = stack.pop();
					if(c==')' && temp!='(') isAvailable = 0;
					else if(c=='}' && temp!='{') isAvailable = 0;
					else if(c==']' && temp!='[') isAvailable = 0;
					else if(c=='>' && temp!='<') isAvailable = 0;
				}
				
				if(isAvailable == 0) break;
			}
			// 출력
			System.out.println("#"+t+" "+isAvailable);
			
		}
	}
}
