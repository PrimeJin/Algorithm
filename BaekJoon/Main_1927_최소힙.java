import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_1927_최소힙 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());  //연산 개수
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num == 0) {  //0일 때는 가장 작은 값 출력하고 제거
				if(!pq.isEmpty()) {
					sb.append(pq.poll()).append("\n");
				} else {  //큐가 비어있을 때는 0출력
					sb.append(0).append("\n");
				}
			} else {
				pq.offer(num);
			}
		}
		System.out.print(sb);
	}
}
