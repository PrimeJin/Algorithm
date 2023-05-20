import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_탈출 {
	static int[] dy = {0, 1, 0, -1};  //우 하 좌 상
	static int[] dx = {1, 0, -1, 0};
	static char[][] map;
	static int R, C;
	static boolean[][] check;
	static boolean flag = false;
	static int level;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());  //행
		C = Integer.parseInt(st.nextToken());  //열
		
		//맵 초기화
		map = new char[R][C];
		int sY = 0;
		int sX = 0;
		int wY = 0;
		int wX = 0;
		for(int i=0; i<R; i++) {
			String str = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == '*') {
					wY = i;
					wX = j;
//					map[i][j] = '0';
				} else if(map[i][j] == 'S') {
					sY = i;
					sX = j;
				}
			}
		}
		
		check = new boolean[R][C];
		
		bfs(sY, sX, wY, wX);
		
		if(flag) {
			System.out.print(level);
		} else {
			System.out.print("KAKTUS");
		}
	}
	
	public static void bfs(int y, int x, int wY, int wX) {
		Queue<Position> queue = new ArrayDeque<>();
		queue.offer(new Position(y, x));
		check[y][x] = true;
		
		
		Queue<Position> waterQueue = new ArrayDeque<>();
		queue.offer(new Position(wY, wX));
		check[wY][wX] = true;
		
		level = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			//물 차지
			int waterSize = waterQueue.size();
			for(int i=0; i<waterSize; i++) {
				Position cur = waterQueue.poll();
				
				for(int j=0; j<4; j++) {
					int ny = cur.y + dy[j];
					int nx = cur.x + dx[j];
					
					if(0<=ny&&ny<R && 0<=nx&&nx<C) {
						if(!check[ny][nx] && map[ny][nx] == '.') {
							waterQueue.offer(new Position(ny, nx));
							check[ny][nx] = true;
						}
					}
				}
			}
			
			//고슴도치 이동
			for(int i=0; i<size; i++) {
				Position cur = queue.poll();
				
				if(map[cur.y][cur.x] == 'D') {
					flag = true;
					return;  //비버 굴 도착
				}
				
				for(int j=0; j<4; j++) {
					int ny = cur.y + dy[j];
					int nx = cur.x + dx[j];
					
					if(0<=ny&&ny<R && 0<=nx&&nx<C) {
						if(!check[ny][nx] && map[ny][nx] == '.') {
							queue.offer(new Position(ny, nx));
							check[ny][nx] = true;
						}
					}
				}
			}
			
			level++;
		}
	}

	static class Position {
		int y;
		int x;
		
		public Position(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
