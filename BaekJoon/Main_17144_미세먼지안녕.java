import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17144_미세먼지안녕 {
	static int[][] map;
	static int[] dy = {0, 1, 0, -1};  //우 하 좌 상
	static int[] dx = {1, 0, -1, 0};
//	static int[] upDy = {0, -1, 0, 1};  //우 상 좌 하
//	static int[] upDx = {1, 0, -1, 0};  //우 상 좌 하
	static int R, C;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());  //행
		C = Integer.parseInt(st.nextToken());  //열
		int T = Integer.parseInt(st.nextToken());  //시간 초
		
		map = new int[R][C];
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cleanR = 0;  //공기청정기 있는 행(윗부분) 위치
		for(int i=0; i<R; i++) {
			if(map[i][0] == -1) {
				cleanR = i;
				break;
			}
		}
		
		for(int i=0; i<T; i++) {
			diffusion();
			clean(cleanR);
		}
		
		//T초 후 방의 미세먼지값(합) 구하기
		int sum = 0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				sum += map[i][j];
			}
		}
		
		sum += 2;  //공기청정기 값더하기 (if문대신)
		
		System.out.print(sum);
	}
	
	public static void diffusion() {
		int[][] diffuseMap = new int[R][C];  //확산되는 양만 계산한 배열
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] > 0) {
					int cnt = 0;  //몇방향으로 확산가능한지
					for(int k=0; k<4; k++) {
						int ny = i + dy[k];
						int nx = j + dx[k];
						
						if(0<=ny&&ny<R && 0<=nx&&nx<C) {
							if(map[ny][nx] != -1) {  //공기 청정기 위치는 확산 X
								cnt++;
								diffuseMap[ny][nx] += map[i][j]/5;  //확산되는 양
							}
						}
					}
					map[i][j] = map[i][j] - (map[i][j]/5)*cnt;  //확산하고 그 칸에 남은 미세먼지 양
				}
			}
		}
		
		//확산된 양 더하기
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				map[i][j] += diffuseMap[i][j];
			}
		}
	}
	
	public static void clean(int y) {
		int[][] copyMap = new int[R][C];
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				copyMap[i][j] = map[i][j];
			}
		}
		
		//공기청정기 기준 위쪽 처리
		map[y][1] = 0;  //공기청정기 바로앞 처리
		//공기청정기 있는 행 처리
		for(int i=2; i<C; i++) {
			map[y][i] = copyMap[y][i-1]; 
		}
		//오른쪽 세로 처리
		for(int i=y-1; i>=0; i--) {
			map[i][C-1] = copyMap[i+1][C-1];
		}
		//위쪽 <- 방향 처리
		for(int i=C-2; i>=0; i--) {
			map[0][i] = copyMap[0][i+1];
		}
		//왼쪽 세로 처리
		for(int i=1; i<y; i++) {
			map[i][0] = copyMap[i-1][0];
		}
		
		//공기청정기 기준 아래부분 처리
		
		map[y+1][1] = 0;  //공기청정기 바로앞 처리
		//공기청정기 있는 행 처리
		for(int i=2; i<C; i++) {
			map[y+1][i] = copyMap[y+1][i-1]; 
		}
		//오른쪽 세로 처리
		for(int i=y+2; i<R; i++) {
			map[i][C-1] = copyMap[i-1][C-1];
		}
		//아래쪽 <- 방향 처리
		for(int i=C-2; i>=0; i--) {
			map[R-1][i] = copyMap[R-1][i+1];
		}
		//왼쪽 세로 처리
		for(int i=R-2; i>y+1; i--) {
			map[i][0] = copyMap[i+1][0];
		}
	}
}
