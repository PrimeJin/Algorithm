import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_TwoPointers_4_연속부분수열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());  //수열 이루어진 숫자 개수
		int M = Integer.parseInt(st.nextToken());  //특정 합
		
		int[] arr = new int[N];  //수열 저장할 배열
		st = new StringTokenizer(br.readLine());
		
		//수열 초기화
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int count = 0;  //조건에 부합하는 경우의 수 
		int lt=0;  //합을 계산할 수열의 왼쪽 시작부분
		int sum = 0;  //부분수열 누적합
		for(int rt=0; rt<N; rt++) {  //rt: 합을 계산할 수열의 오른쪽 끝부분
			sum += arr[rt];
			if(sum == M) count++;
			
			while(sum>=M) {  //원하는 합보다 크거나 같아지면 lt는 증가시키고  누적합에서 arr[lt]값 빼기
				sum -= arr[lt++];
				if(sum == M) count++;
			}
		}
		
		System.out.println(count);
	}
}
