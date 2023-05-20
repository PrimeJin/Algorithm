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
	static boolean flag;
	static int level;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());  //행
		C = Integer.parseInt(st.nextToken());  //열
		
		//맵 초기화
		map = new char[R][C];
		int sY = 0;  //고슴도치 출발 좌표 Y
		int sX = 0;  //고슴도치 출발 좌표 X
		for(int i=0; i<R; i++) {
			String str = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'S') {
					sY = i;
					sX = j;
				}
			}
		}
		
		check = new boolean[R][C];
		flag = false;
		bfs(sY, sX);
		
		if(flag) {  //비버굴로 도착가능할 때
			System.out.print(level);
		} else {  //비버굴로 도착 불가능할 때
			System.out.print("KAKTUS");
		}
	}
	
	public static void bfs(int y, int x) {
		Queue<Position> queue = new ArrayDeque<>();  //고슴도치 이동지점 queue
		queue.offer(new Position(y, x));
		check[y][x] = true;
		
		Queue<Position> waterQueue = new ArrayDeque<>();  //물 이동지점 queue
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] == '*') {
					waterQueue.offer(new Position(i, j));
					check[i][j] = true;
				}
			}
		}
		
		level = 0;  //걸리는 시간(queue 레벨)
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
						if(!check[ny][nx] && map[ny][nx] != 'X') {
							queue.offer(new Position(ny, nx));
							check[ny][nx] = true;
						}
					}
				}
			}
			
			level++;  //시간초 (queue레벨) 증가
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
