import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1107_리모콘 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());  //이동하려는 채널
		int M = Integer.parseInt(br.readLine());  //고장난 버튼 개수
		
		boolean[] broken = new boolean[10];
		if(M > 0) {  //M이 0이면 3번째줄 입력받으면 안됨
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<M; i++) {
				broken[Integer.parseInt(st.nextToken())] = true;
			}
		}
		
		int normalMove = Math.abs(N - 100);
		int move = Integer.MAX_VALUE;
		for(int i=0; i<1000000; i++) {
			String str = "" + i;
			int len = str.length();
			
			boolean flag = false;
			for(int j=0; j<len; j++) {
				if(broken[str.charAt(j) - '0']) {
					flag = true;
					break;
				}
			}
			
			if(!flag) {
				int cnt = Math.abs(N-i) + len;
				move = Math.min(move, cnt);
			}
		}
		
		System.out.print(Math.min(normalMove, move));
	}
		
}
