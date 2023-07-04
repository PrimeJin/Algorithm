import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1629_곱셈 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long A = Integer.parseInt(st.nextToken());
		long B = Integer.parseInt(st.nextToken());
		long C = Integer.parseInt(st.nextToken());
		
		System.out.print(calculate(A,B,C));
	}
	
	public static long calculate(long a, long b, long c) {
		if(b == 1) {
			return a%c;
		}
		
		long temp = calculate(a, b/2, c);
		if(b%2 == 1) {
			return temp*temp%c * a%c;
		}
		
		return temp*temp%c;
	}

}
