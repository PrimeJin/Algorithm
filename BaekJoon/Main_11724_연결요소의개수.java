import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11724_연결요소의개수 {
	static boolean[][] connect;
	static boolean[] check;
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());  //정점 개수
		M = Integer.parseInt(st.nextToken());  //간선 개수
		
		connect = new boolean[N+1][N+1];  //연결상태 담은배열
		check = new boolean[N+1];  //정점 방문 체크 배열
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			//간선 양끝점
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			connect[u][v] = true;
			connect[v][u] = true;
		}
		
		int cnt = 0;  //연결 요소 개수
		for(int i=1; i<=N; i++) {
			if(!check[i]) {
				check[i] = true;
				dfs(i);
				cnt++;
			}
		}
		
		System.out.print(cnt);
	}
	
	public static void dfs(int start) {
		for(int i=1; i<=N; i++) {
			if(!check[i] && connect[start][i]) {
				check[i] = true;
				dfs(i);
			}
		}
	}
}
