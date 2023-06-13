import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());  //카드 개수
		st = new StringTokenizer(br.readLine());
		
		int[] card = new int[20000001];
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if(num < 0) {
				num = num*(-1) + 10000000;
			}
			
			card[num]++;
		}
		
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if(num < 0) {
				num = num*(-1) + 10000000;
			}
			sb.append(card[num]).append(" ");
		}
		
		System.out.print(sb);
	}

}
