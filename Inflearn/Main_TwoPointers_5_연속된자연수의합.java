import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_TwoPointers_5_연속된자연수의합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int lt=0;
		int sum = 0;
		int count =0;
		//TwoPointers 활용
		for(int rt=0; rt<N/2 + 1; rt++) {
			sum += (rt+1);
			if(sum == N) {
				count++;
			}
			
			while(sum>=N) {
				sum -= (lt+1);
				lt++;
				if(sum == N) {
					count++;
				}
			}
		}
		
		System.out.println(count);
	}
}
