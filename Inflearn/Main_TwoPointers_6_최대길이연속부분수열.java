import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_TwoPointers_6_최대길이연속부분수열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());  //수열 길이
		int k = Integer.parseInt(st.nextToken());  //최대 변경 가능 횟수
		
		int[] arr = new int[N];  //길이가 N인 수열
		//수열 초기화
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int lt=0;
		int count=0;  //0을 1로 변경하는 횟수
		int maxLength=0;  //1로만 구성된 연속부분수열 최대길이
		for(int rt=0; rt<N; rt++) {
			if(arr[rt]==0) count++;
			while(count>k) {
				if(arr[lt] == 0) count--;
				lt++;
			}
			maxLength = Math.max(rt-lt+1, maxLength);
		}
		
		System.out.println(maxLength);
		
	}
}
