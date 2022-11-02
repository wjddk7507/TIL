import java.util.Scanner;

public class Main_1110_더하기싸이클 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int temp = N/10+N%10;
		int newNum = Integer.parseInt(N%10+""+temp%10);
		int cnt = 1;
		
		while(true) {
			temp = newNum/10+newNum%10;
			newNum = Integer.parseInt((newNum%10)+""+temp%10);
			cnt++;
			
			if(newNum == N) break;
		}
		System.out.println(N==0?1:cnt);
	}
	
}
