import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] S;
	static boolean[] isSelected;
	static int min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());  //총 인원 수
		//배열 초기화 
		S = new int[N][N];
		isSelected = new boolean[N];  //체크 배열
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		min = Integer.MAX_VALUE;  //최솟값 비교하기 위해 정수형 최대값으로 초기화
		comb(0,0);
		System.out.println(min);
	}
	
	public static void comb(int start, int cnt) {
		int half = N/2;
		if(cnt == half) {
			int sTeam = 0;  //스타트 팀
			int lTeam = 0;  //링크 팀 
			for(int i=0; i<N-1; i++) {
				for(int j=i+1; j<N; j++) {
					if(isSelected[i] && isSelected[j]) {
						sTeam += S[i][j];
						sTeam += S[j][i];
					} else if(!isSelected[i] && !isSelected[j]) {
						lTeam += S[i][j];
						lTeam += S[j][i];
					}
				}
			}
			min = Math.min(min, Math.abs(sTeam - lTeam));
			return;
		}
		
		for(int i=start; i<N; i++) {
			isSelected[i] = true;
			comb(i+1, cnt+1);
			isSelected[i] = false;
		}
		
	}
}
