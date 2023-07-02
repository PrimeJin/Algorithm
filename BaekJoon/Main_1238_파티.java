import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
	static int N, M, X;
	static List<Idx>[] list;
	static List<Idx>[] backList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());  //학생 수
		M = Integer.parseInt(st.nextToken());  //단방향 도로
		X = Integer.parseInt(st.nextToken());  //마을
		
		list = new ArrayList[N+1];
		backList = new ArrayList[N+1];
		for(int i=0; i<=N; i++) {
			list[i] = new ArrayList<>();
			backList[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			list[start].add(new Idx(end, cost));
			backList[end].add(new Idx(start, cost));
		}
		
		int[] result1 = bfs(list);
		int[] result2 = bfs(backList);
		
		int answer = 0;
		for(int i=1; i<=N; i++) {
			answer = Math.max(answer, result1[i] + result2[i]);
		}
		
		System.out.print(answer);
	}
	
	public static int[] bfs(List<Idx>[] tmpList) {
		boolean[] check = new boolean[N+1];
		int[] cost = new int[N+1];
		PriorityQueue<Idx> queue = new PriorityQueue<>();
		queue.offer(new Idx(X, 0));
		Arrays.fill(cost, Integer.MAX_VALUE);
		cost[X] = 0;
		
		while(!queue.isEmpty()) {
			Idx cur = queue.poll();
			
			if(!check[cur.idx]) {
				check[cur.idx] = true;
				for(Idx x : tmpList[cur.idx]) {
					if(!check[x.idx] && cost[x.idx] > cost[cur.idx] + x.cost) {
						cost[x.idx] = cost[cur.idx] + x.cost;
						queue.offer(new Idx(x.idx, cost[x.idx]));
					}
				}
			}
		}
		
		return cost;
	}
	
	static class Idx implements Comparable<Idx> {
		int idx;
		int cost;
		
		public Idx(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Idx o) {
			return this.cost - o.cost;
		}
	}
}
