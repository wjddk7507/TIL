import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_안경이없어 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String nohole = "CEFGHIJKLMNSTUVWXYZ";
		String hole = "ADOPQR";
		for(int t = 1; t <= T; t++) {
			boolean isSame = true;
			String[] arr = br.readLine().split(" ");
			if(arr[0].length() != arr[1].length()) isSame = false;
			else {
				for(int i = 0; i < arr[0].length(); i++) {
					String c1 = String.valueOf(arr[0].charAt(i));
					String c2 = String.valueOf(arr[1].charAt(i));
					if(nohole.contains(c1) && !nohole.contains(c2)) isSame = false;
					else if(hole.contains(c1) && !hole.contains(c2)) isSame = false;
					else if(c1.equals("B") && !c2.equals("B")) isSame = false;
				}
			}
			
			System.out.println("#"+t+" "+(isSame?"SAME":"DIFF"));
		}
	}
}
