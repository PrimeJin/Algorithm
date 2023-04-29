import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2167_2차원배열의합 {  //누적합 이용 (시간복잡도 고려)
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		//원래 2차원 배열 입력
		int[][] arr = new int[N+2][M+2];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//가로 누적합
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				arr[i][j+1] += arr[i][j];
			}
		}
		
		//세로 누적합
		for(int j=1; j<=M; j++) {
			for(int k=1; k<=N; k++) {
				arr[k+1][j] += arr[k][j];
			}
		}
	
		int K = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();  //정답 담을 StringBuilder
		//정해진 구간 누적합 구하기
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int r1 = Integer.parseInt(st.nextToken());
			int c1 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			
			int answer = arr[r1-1][c1-1] - arr[r1-1][c2] - arr[r2][c1-1] + arr[r2][c2];
			sb.append(answer).append("\n");
		}
		
		System.out.print(sb);  //답 출력
	}
}
