import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_11866_요세푸스문제0 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N+1];
		for(int i=0; i<N+1; i++) {
			arr[i] = i;
		}
		
		Queue<Integer> queue = new ArrayDeque<Integer>();
		
		for(int i=1; i<=N; i++) {
			queue.offer(i);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		while(!queue.isEmpty()) {
			//K-1번만큼은 queue에서 빼서 다시 집어넣고
			for(int i=0; i<K-1; i++) {
				queue.offer(queue.poll());
			}
			
			//K번째는 queue에서 빼서 답에 넣고 끝
			if(queue.size()==1) {  //마지막 한사람 남았을 때 처리
				sb.append(queue.poll()).append(">");
				break;
			} else {
				sb.append(queue.poll()).append(", ");
			}
		}
		
		System.out.print(sb);
	}
}
