import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Main_1753_최단경로 {
	static List<List<Dist>> list;
	static int V;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());  //정점 개수
		int E = Integer.parseInt(st.nextToken());  //간선 개수
		
		list = new ArrayList<List<Dist>>();
		for(int i=0; i<=V; i++) {
			list.add(new ArrayList<>());
		}
		
		int K = Integer.parseInt(br.readLine());  //시작 정점 번호
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());  //출발
			int v = Integer.parseInt(st.nextToken());  //도착
			int w = Integer.parseInt(st.nextToken());  //가중치
			
			list.get(u).add(new Dist(v, w));
		}
		
		int[] result = bfs(K);
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=V; i++) {
			if(i==K) {
				sb.append(0).append("\n");
			} else if(result[i] == Integer.MAX_VALUE) {
				sb.append("INF").append("\n");
			} else {
				sb.append(result[i]).append("\n");
			}
		}
		
		System.out.print(sb);
	}
	
	public static int[] bfs(int start) {
		PriorityQueue<Dist> pq = new PriorityQueue<>();
		pq.offer(new Dist(start, 0));
		int[] cost = new int[V+1];
//		boolean[] check = new boolean[V+1];
//		check[start] = true;
		Arrays.fill(cost, Integer.MAX_VALUE);
		
		while(!pq.isEmpty()) {
			Dist cur = pq.poll();
			
			for(Dist next : list.get(cur.end)) {
				if(cost[next.end] > cur.dist + next.dist) {
					cost[next.end] = cur.dist + next.dist;
					pq.add(new Dist(next.end, cost[next.end]));
				}
			}
		}
		
		return cost;
		
	}
	
	static class Dist implements Comparable<Dist> {
		int end;
		int dist;
		
		public Dist(int end, int dist) {
			this.end = end;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Dist o) {
			return this.dist - o.dist;
		}
	}
}
