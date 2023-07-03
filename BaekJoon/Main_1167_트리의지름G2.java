import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1167_트리의지름 {
	static List<Node>[] listArr;
	static boolean[] visited;
	static int max;
	static int maxIdx;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int V = Integer.parseInt(br.readLine());  //정점 개수
		
		listArr = new ArrayList[V+1];
		for(int i=1; i<V+1; i++) {
			listArr[i] = new ArrayList<>();
		}
		
		for(int i=0; i<V; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			
			int cnt = st.countTokens();
			for(int j=0; j<cnt/2; j++) {
				int to = Integer.parseInt(st.nextToken());
				int dist = Integer.parseInt(st.nextToken());
				
				listArr[from].add(new Node(to, dist));
				listArr[to].add(new Node(from, dist));
			}
			
		}
		
		//임의 한 정점에서 최대 길이가지는 정점 구하기
		max = 0;
		maxIdx = 1;  //임의 한 정점에서 최대 길이가지는 정점
		visited = new boolean[V+1];
		visited[1] = true;
		dfs(1, 0);
		
		//그 정점에서 끝까지 최대 길이 구하기
		visited = new boolean[V+1];
		visited[maxIdx] = true;
		dfs(maxIdx, 0);
		
		System.out.print(max);
	}
	
	public static void dfs(int idx, int sum) {
		if(max < sum) {
			max = sum;
			maxIdx = idx;
		}
		
		for(Node x : listArr[idx]) {
			if(!visited[x.num]) {
				visited[x.num] = true;
				dfs(x.num, sum + x.dist);
			}
		}
		
	}

	
	static class Node {
		int num;
		int dist;
		
		public Node(int num, int dist) {
			this.num = num;
			this.dist = dist;
		}
	}
}
