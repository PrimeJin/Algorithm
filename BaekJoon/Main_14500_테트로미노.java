import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14500_테트로미노 {
	static int[][] map;
	static int N, M;
	static int[] dy = {0, 1, 0, -1};  //우 하 좌 상
	static int[] dx = {1, 0, -1, 0};
	static int max;
	static boolean[][] check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());  //세로
		M = Integer.parseInt(st.nextToken());  //가로
		
		map = new int[N][M];
		check = new boolean[N][M];
		//맵 초기화
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		max = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				check[i][j] = true;
				dfs(i, j, 0, 0);  //주어진 블럭들을 회전, 대칭 시키면 결국 depth가 4인 dfs
				check[i][j] = false;
				purple(i, j);  //dfs로 구할 수없는 보라색 ㅗ모양 블럭 처리
			}
		}
		
		System.out.print(max);
	}
	
	public static void dfs(int y, int x, int cnt, int sum) {
		if(cnt == 4) {
			max = Math.max(max, sum);
			return;
		}
		
		for(int i=0; i<4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(0<=ny&&ny<N && 0<=nx&&nx<M) {
				if(!check[ny][nx]) {
					check[ny][nx] = true;
					dfs(ny, nx, cnt+1, sum+map[ny][nx]);
					check[ny][nx] = false;
				}
			}
		}
	}
	
	public static void purple(int y, int x) {  //dfs로 구할 수없는 보라색 ㅗ모양 블럭 처리
		if(y+1<N && x+2<M) {  //ㅜ
			max = Math.max(max, map[y][x] + map[y][x+1] + map[y][x+2] + map[y+1][x+1]);
		}
		
		if(y+2<N && x-1>=0) { //ㅓ
			max = Math.max(max, map[y][x] + map[y+1][x] + map[y+2][x] + map[y+1][x-1]);
		}
		
		if(y-1>=0 && x+2<M) {  //ㅗ
			max = Math.max(max, map[y][x] + map[y][x+1] + map[y][x+2] + map[y-1][x+1]);
		}
		
		if(y+2<N && x+1<M) {  //ㅏ
			max = Math.max(max, map[y][x] + map[y+1][x] + map[y+2][x] + map[y+1][x+1]);
		}
		
	}
}
