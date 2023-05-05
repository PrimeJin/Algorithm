import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_BOJ_2210_숫자판점프 {
	static int[] dy = {0, 1, 0, -1};  // 우 하 좌 상
	static int[] dx = {1, 0, -1, 0};  // 우 하 좌 상
	static int[][] numArr;
	static StringBuilder sb = new StringBuilder();
	static Map<String, Integer> map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		numArr = new int[5][5];
		for(int i=0; i<5; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++) {
				numArr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		map = new HashMap<>();  //중복 제거를 위한 map
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				dfs(i, j, 1, numArr[i][j] + "");
			}
		}
		
//		for(String x : map.keySet()) {
//			System.out.println(x + " ");
//		}
		System.out.print(map.size());
	}
	
	public static void dfs(int y, int x, int cnt, String str) {
		if(cnt == 6) {
			map.put(str, map.getOrDefault(str, 0) + 1);
			return;  //여섯 자리 수 되면 그만
		}
		
		for(int i=0; i<4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(0<=ny&&ny<5 && 0<=nx&&nx<5) {
				dfs(ny, nx, cnt+1, str + numArr[ny][nx]);
			}
		}
	}
	

}
