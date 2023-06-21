import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1003_피보나치함수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		Count[] dp = new Count[41];
		dp[0] = new Count(1, 0);
		dp[1] = new Count(0, 1);
		
		for(int i=2; i<=40; i++) {
			dp[i] = new Count((dp[i-1].cnt0 + dp[i-2].cnt0), (dp[i-1].cnt1 + dp[i-2].cnt1));
		}
		
		for(int t=0; t<T; t++) {
			int N = Integer.parseInt(br.readLine());
			sb.append(dp[N].cnt0).append(" ").append(dp[N].cnt1).append("\n");
		}
		
		//재귀방법 시간초과(0.25)
//		for(int t=0; t<T; t++) {
//			int N = Integer.parseInt(br.readLine());
//			cnt0 = 0;
//			cnt1 = 0;
//			fibonacci(N);
//			sb.append(cnt0).append(" ").append(cnt1).append("\n");
//		}
		System.out.print(sb);
	}
	
	//재귀방법 시간초과(0.25)
//	public static int fibonacci(int n) {
//		if(n==0) {
//			cnt0++;
//			return 0;
//		} else if(n==1) {
//			cnt1++;
//			return 1;
//		} else {
//			return fibonacci(n-1) + fibonacci(n-2);
//		}
//	}
	
	static class Count {
		int cnt0;  //0 출력 횟수
		int cnt1;  //1 출력 횟수
		
		public Count(int cnt0, int cnt1) {
			this.cnt0 = cnt0;
			this.cnt1 = cnt1;
		}
	}
}
