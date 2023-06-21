import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1931_회의실배정 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		Meeting[] meet = new Meeting[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			meet[i] = new Meeting(s, e);
		}
		
		//회의가 빨리 끝나는 순서로 정렬, 회의 끝나는 시간이 같으면 빨리 시작하는 순서로 정렬 (이래야 가장 많은 회의 가능)
		Arrays.sort(meet, (o1, o2) -> o1.end==o2.end? o1.start-o2.start : o1.end-o2.end);
		
		int cur = 0;
		int cnt = 0;
		for(int i=0; i<N; i++) {
			if(cur <= meet[i].start) {
				cur = meet[i].end;
				cnt++;
			}
		}
		
		System.out.print(cnt);
	}
	
	static class Meeting {
		int start;
		int end;
		
		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
}
