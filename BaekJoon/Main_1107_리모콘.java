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
		for(int i=0; i<1000000; i++) {	//브루트포스로 999999채널까지 눌러보는 경우 대비
			String str = "" + i;
			int len = str.length();
			
			boolean flag = false;  //해당 채널만들때 고장난 버튼이 있는지 여부체크
			for(int j=0; j<len; j++) {
				if(broken[str.charAt(j) - '0']) {
					flag = true;
					break;
				}
			}
			
			if(!flag) {  //고장난 버튼없이 만든 채널이면
				int cnt = Math.abs(N-i) + len;  //Math.abs(N-i)이 채널에서 목표채널로 +or-로 이동하는데 필요한 횟수 + (len)채널입력하는데 필요한 누른 횟수
				move = Math.min(move, cnt);  //가장 최소 횟수 저장
			}
		}
		
		System.out.print(Math.min(normalMove, move));  //100에서 + -로 이동하는 것보다 누른 횟수가 적은지 비교
	}
		
}
