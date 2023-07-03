import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1967_트리의지름 {
	static boolean[] visited;
	static List<Node>[] listArr;
	static int max;
	static int maxIdx;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());  //노드 개수
		listArr = new ArrayList[n+1];
		
		for(int i=1; i<=n; i++) {
			listArr[i] = new ArrayList<>();
		}
		
		for(int i=0; i<n-1; i++) {
			st = new StringTokenizer(br.readLine());
			
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			listArr[p].add(new Node(c, v, 0));
			listArr[c].add(new Node(p, v, 0));
		}
		
		max = 0;
		maxIdx = 1;  //루트를 기준으로 했을 때 가장 길이가 긴 정점
		//루트를 기준으로 했을 때 가장 길이가 긴 정점 구하기
		visited = new boolean[n+1];
		visited[1] = true;
		dfs(1, 0);
		
		//루트 기준 가장 길이가 긴 정점으로 dfs
		visited = new boolean[n+1];
		visited[maxIdx] = true;
		dfs(maxIdx, 0);
		
		System.out.print(max);
	}
	
	public static void dfs(int start, int sum) {
		for(Node x : listArr[start]) {
			if(!visited[x.num]) {
				visited[x.num] = true;
				dfs(x.num, sum + x.dist);
			}
		}
		
		if(max < sum) {
			max = sum;
			maxIdx = start;
		}
	}
	
	static class Node {
		int num;
		int dist;

		public Node(int num, int dist, int sum) {
			this.num = num;
			this.dist = dist;
		}
	}
}
