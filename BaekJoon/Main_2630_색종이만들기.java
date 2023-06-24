import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2630_색종이만들기 {
	static int[][] map;
	static Queue<Square> queue;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());  //변 길이
		map = new int[N][N];
		queue = new ArrayDeque<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int white = 0;
		int blue = 0;
		queue.offer(new Square(0, 0, N));
		
		while(!queue.isEmpty()) {
			Square cur = queue.poll();
			if(check(cur.y, cur.x, cur.len)) { //정사각형 색종이 성립
				if(map[cur.y][cur.x] == 0) {
					white++;
				} else {
					blue++;
				}
			} else {
				int newLen = cur.len/2;
				queue.offer(new Square(cur.y, cur.x, newLen));
				queue.offer(new Square(cur.y, cur.x+newLen, newLen));
				queue.offer(new Square(cur.y+newLen, cur.x, newLen));
				queue.offer(new Square(cur.y+newLen, cur.x+newLen, newLen));
			}
		}
		
		System.out.println(white + "\n" + blue);
	}
	
	
	public static boolean check(int y, int x, int len) {
		int color = map[y][x];
		for(int i=y; i<y+len; i++) {
			for(int j=x; j<x+len; j++) {
				if(map[i][j] != color) {
					return false;
				}
			}
		}
		
		//정사각형 색종이 성립
		return true;
	}
	
	static class Square {
		int y;
		int x;
		int len;
		
		public Square(int y, int x, int len) {
			this.y = y;
			this.x = x;
			this.len = len;
		}
	}
}
