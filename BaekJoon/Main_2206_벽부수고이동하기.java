import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2206_벽부수고이동하기 {
	static int[][] map;
	static int[] dy = {0, 1, 0, -1};  //우 하 좌 상
	static int[] dx = {1, 0 , -1, 0};
	static int N, M;
	static boolean[][][] visited;
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());  //세로
		M = Integer.parseInt(st.nextToken());  //가로
		
		map = new int[N+1][M+1];
		for(int i=1; i<=N; i++) {
			String tmp = br.readLine();
			for(int j=1; j<=M; j++) {
				map[i][j] = tmp.charAt(j-1) - '0';
			}
		}
		
		visited = new boolean[N+1][M+1][2];  //[][][0]:벽 부수지 않고 탐색할때 방문처리,  [][][1]:벽 부수고 탐색할때 방문처리
		answer = 0;

		bfs();
		
		System.out.print(answer);
	}
	
	public static void bfs() {
		Queue<Position> queue = new ArrayDeque<>();
		queue.offer(new Position(1, 1, 1, 0));
		visited[1][1][0] = true;
		
		boolean possible = false;
		while(!queue.isEmpty()) {
			Position cur = queue.poll();
//			System.out.println("y:" + cur.y + ", x:" + cur.x + ", level:" + cur.level + ", use:" + cur.use);
			
			if(cur.y==N && cur.x==M) {
				possible = true;
				answer = cur.level;
				return;
			}
			
			for(int i=0; i<4; i++) {
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];
				
				if(1<=ny&&ny<=N && 1<=nx&&nx<=M) {
					if(map[ny][nx]==0) {  //벽이 아닐 때
						if(cur.use==0 && !visited[ny][nx][0]) {  //여태 부신 벽이 없으면
							visited[ny][nx][0] = true;  //부수지않고 탐색하는 visited 방문처리
							queue.offer(new Position(ny, nx, cur.level+1, cur.use));
						} else if(cur.use==1 && !visited[ny][nx][1]) {  //여태 부신 벽이 있으면
							visited[ny][nx][1] = true;  //부수고 탐색하는 visited 방문처리
							queue.offer(new Position(ny, nx, cur.level+1, cur.use));
						}
					} else if(map[ny][nx]==1 && !visited[ny][nx][1] && cur.use==0) {  //벽일 때 여태 부신 벽이 없으면
						visited[ny][nx][1] = true;
						queue.offer(new Position(ny, nx, cur.level+1, cur.use+1));  //벽 부수고 이동
					}
				}
			}
		}
		
		if(!possible) {  //도착지점까지 도착을 못하는 경우 답 -1
			answer = -1;
		}
	}
	
	static class Position {
		int y;
		int x;
		int level;  //bfs레벨 (걸린 거리)
		int use;  //벽 부순 횟수
		
		public Position(int y, int x, int level, int use) {
			this.y = y;
			this.x = x;
			this.level = level;
			this.use = use;
		}
	}
}
