import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_12851_숨바꼭질2 {
	static int K;
	static int minTime, cnt;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());  //수빈 위치
		K = Integer.parseInt(st.nextToken());  //동생 위치
		
		minTime = 0;  //동생찾는 가장 빠른 시간
		cnt = 0;  //가장 빠른시간으로 동생 찾는 방법의 수
		visited = new boolean[100001];
		
		bfs(N);
		
		System.out.println(minTime);
		System.out.print(cnt);
	}
	
	public static void bfs(int num) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(num);
		
		int level = 0;
		boolean flag = false;  //수빈이가 동생만났는지 여부
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i=0; i<size; i++) {
				int cur = queue.poll();
				visited[cur] = true;
				
				if(cur == K) {
					minTime = level;
					cnt++;
					flag = true;
				}
				
				if(cur>=1 && !visited[cur-1]) queue.offer(cur-1);
				if(cur+1<=100000 && !visited[cur+1]) queue.offer(cur+1);
				if(cur*2<=100000 && !visited[cur*2]) queue.offer(cur*2);
			}
			
			if(flag) return;  //최단시간(레벨)에서 가능한 경우만 판단하므로 동생 만난 최소레벨에서만 탐색하고 return
			level++;
		}
	}
}
