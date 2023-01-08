import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_SlidingWindow_3_최대매출 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());  //주어진 총 매출기록 일 수
		int K = Integer.parseInt(st.nextToken());  //최대매출 구하려는 연속 일 수 
		
		st = new StringTokenizer(br.readLine());
		int[] sales = new int[N];  //매출 기록
		//매출기록 초기화
		for(int i=0; i<N; i++) {
			sales[i] = Integer.parseInt(st.nextToken());
		}

		//슬라이딩 윈도우 활용방법
		int sum = 0;  //연속매출 누적값
		for(int i=0; i<K; i++) {
			sum += sales[i];
		}
		
		int max = sum;  //연속매출 누적최대값 (초기 최대값은 처음 누적값)
		for(int i=K; i<N; i++) {
			sum += sales[i] - sales[i-K];
			max = Math.max(sum, max);
		}
		
		System.out.println(max);
		
		//기존 풀이 방법
//		int start = 0;  //연속매출 계산 시작일
//		int max = 0;  //연속매출 누적최대값
//		while(start<N-(K-1)) {
//			int sum = 0;
//			for(int i=start; i<start+K; i++) {
//				sum += sales[i];
//			}
//			start++;
//			max = Math.max(max, sum);
//		}
//		
//		System.out.println(max);
	}
}
