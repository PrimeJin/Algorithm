import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_10866_덱 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Deque<Integer> deque = new ArrayDeque<>();
		
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			String cmd = st.nextToken();
			
			switch (cmd) {
				case "push_back":
					deque.addLast(Integer.parseInt(st.nextToken()));
					break;
				case "push_front":
					deque.addFirst(Integer.parseInt(st.nextToken()));
					break;
				case "pop_front":
					if(!deque.isEmpty()) {
						sb.append(deque.pollFirst()).append("\n");
					} else {
						sb.append(-1).append("\n");
					}
					break;
				case "pop_back":
					if(!deque.isEmpty()) {
						sb.append(deque.pollLast()).append("\n");
					} else {
						sb.append(-1).append("\n");
					}
					break;
				case "size":
					sb.append(deque.size()).append("\n");
					break;
				case "empty":
					sb.append(deque.isEmpty()?1:0).append("\n");
					break;
				case "front":
					if(!deque.isEmpty()) {
						sb.append(deque.peekFirst()).append("\n");
					} else {
						sb.append(-1).append("\n");
					}
					break;
				case "back":
					if(!deque.isEmpty()) {
						sb.append(deque.peekLast()).append("\n");
					} else {
						sb.append(-1).append("\n");
					}
					break;
			}
		}
		System.out.print(sb);
	}
}
