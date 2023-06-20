import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1012_유기농배추 {
	static int[] dy = {0, 1, 0, -1};  //우 하 좌 상
	static int[] dx = {1, 0, -1, 0};
	static int[][] map;
	static boolean[][] visited;
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());  //테스트케이스 개수
		StringBuilder sb = new StringBuilder();
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());  //가로
			N = Integer.parseInt(st.nextToken());  //세로
			int K = Integer.parseInt(st.nextToken());  //배추 심은 위치 개수
			
			map = new int[N][M];
			visited = new boolean[N][M];
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				map[y][x] = 1;
			}
			
			int cnt = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j]==1 && !visited[i][j]) {
						dfs(i, j);
						cnt++;
					}
				}
			}
			
			sb.append(cnt).append("\n");
		}
		System.out.print(sb);
		
	}
	
	public static void dfs(int y, int x) {
		for(int i=0; i<4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(ny<0 || ny>=N || nx<0 || nx>=M) continue;
			if(map[ny][nx]==1 && !visited[ny][nx]) {
				visited[ny][nx] = true;
				dfs(ny, nx);
			}
		}
	}
	
//	static class Position {
//		int y;
//		int x;
//		
//		public Position(int y, int x) {
//			this.y = y;
//			this.x = x;
//		}
//	}

}
