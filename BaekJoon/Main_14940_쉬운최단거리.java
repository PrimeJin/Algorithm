import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14940_쉬운최단거리 {
	static int[][] map;
	static int[][] memo;  //목표지점까지의 거리 메모한 배열
	static int[] dy = {0, 1, 0, -1};  //우 하 좌 상
	static int[] dx = {1, 0, -1, 0};
	static boolean[][] visited;
	static int n,m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		visited = new boolean[n][m];
		int targetY=0;
		int targetX=0;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					targetY = i;
					targetX = j;
				}
			}
		}
		memo = new int[n][m];
		bfs(targetY, targetX);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(!visited[i][j] && map[i][j]==1) {  //원래 갈 수 있는 땅(1)인데 도달하지 못하는 경우는 -1로 출력
					sb.append(-1).append(" ");
				} else {
					sb.append(memo[i][j]).append(" ");
				}
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
	}
	
	public static void bfs(int y, int x) {
		Queue<Position> queue = new ArrayDeque<>();
		queue.offer(new Position(y, x, 0));
		visited[y][x] = true;
		
		while(!queue.isEmpty()) {
			Position cur = queue.poll();
			
			for(int i=0; i<4; i++) {
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];
				
				if(ny<0 || ny>=n || nx<0 || nx>=m) continue;
				
				if(!visited[ny][nx]) {
					visited[ny][nx] = true;
					if(map[ny][nx] == 1) {
						memo[ny][nx] = cur.distance + 1;
						queue.offer(new Position(ny, nx, cur.distance+1));
					}
				}
				
			}
		}
	}
	
	static class Position {
		int y;
		int x;
		int distance;
		
		public Position(int y, int x, int distance) {
			this.y = y;
			this.x = x;
			this.distance = distance;
		}
	}
}
