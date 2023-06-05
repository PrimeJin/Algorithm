import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1476_날짜계산 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//E   S   M 
		//15  28  19
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int e = 0;
		int s = 0;
		int m = 0;
		int year = 0;
		//간단한 풀이방법
		while(true) {
			if(e==E && s==S && m==M) {
				System.out.println(year);
				break;
			}
			
			e++;
			s++;
			m++;
			year++;
			
			if(e>15) e=1;
			if(s>28) s=1;
			if(m>19) m=1;
		}
		
		//첫번째로 푼 풀이방법
//		if(E==S && S==M) {
//			System.out.println(E);
//		} else {
//			int cycleE = 0;
//			int year = 0;
//			while(true) {
//				year = cycleE*15 + E;
//				
//				if(((S==28 && year%28==0) || year%28==S) && ((M==19 && year%19==0) || year%19==M)) {
//					System.out.print(year);
//					break;
//				}
//				cycleE++;
//			}
//		}
		
	}

}
