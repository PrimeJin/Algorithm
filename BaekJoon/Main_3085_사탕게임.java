import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_3085_사탕게임 {
	static char[][] chArr;
	static int[] dy = {0, 1, 0, -1};  //우 하 좌 상
	static int[] dx = {1, 0, -1, 0};
	static int N;
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());  //보드 크기
		
		chArr = new char[N][N];
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++) {
				chArr[i][j] = str.charAt(j);
			}
		}
		
		answer = 1;  //정답(최대개수)
		//초기 상태에서의 먹을 수 있는 사탕 최대 개수 구하기
		for(int i=0; i<N; i++) {
			int rCount = 1;
			char tmp = chArr[i][0];
			for(int j=1; j<N; j++) {
				if(tmp == chArr[i][j]) {
					rCount++;
					answer = Math.max(answer, rCount);
				} else {
					tmp = chArr[i][j];
					rCount = 1;
				}
			}
			
			int cCount = 1;
			tmp = chArr[0][i];
			for(int j=1; j<N; j++) {
				if(tmp == chArr[j][i]) {
					cCount++;
					answer = Math.max(answer, cCount);
				} else {
					tmp = chArr[j][i];
					cCount = 1;
				}
			}
		}
		
		//위치 바꾸고나서 최대개수 변화 구하기
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				swap(i, j);
			}
		}
		
		System.out.print(answer);
	}
	
	public static void swap(int y, int x) {
		for(int i=0; i<4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(0<=ny&&ny<N && 0<=nx&&nx<N) {
				if(chArr[ny][nx] != chArr[y][x]) {  //같을 때는 바꾸는게 의미없음
					char tmp = chArr[y][x];
					chArr[y][x] = chArr[ny][nx];
					chArr[ny][nx] = tmp;
					
					count(chArr, y, x);
					//다시 원상태로 돌려놓기
					chArr[ny][nx] = chArr[y][x];
					chArr[y][x] = tmp;
				}
			}
		}
	}
	
	public static void count(char[][] swapArr, int y, int x) {
		//바꾼 위치와 같은 행 비교
		char tmp = swapArr[y][0];
		int rCount = 1;
		for(int i=1; i<N; i++) {
			if(tmp == swapArr[y][i]) {
				rCount++;
				answer = Math.max(answer, rCount);
			} else {
				tmp = swapArr[y][i];
				rCount = 1;
			}
		}
		
		//바꾼 위치와 같은 열 비교
		tmp = swapArr[0][x];
		int cCount = 1;
		for(int i=1; i<N; i++) {
			if(tmp == swapArr[i][x]) {
				cCount++;
				answer = Math.max(answer, cCount);
			} else {
				tmp = swapArr[i][x];
				cCount = 1;
			}
		}
	}
}
