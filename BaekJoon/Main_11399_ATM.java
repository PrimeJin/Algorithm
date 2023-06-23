import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11399_ATM {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());  //사람 수
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];  //인출하는데 걸리는 시간 배열
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int sum = arr[0];
		for(int i=1; i<N; i++) {
			arr[i] += arr[i-1];
			sum += arr[i];
		}
		
		System.out.print(sum);
		
	}
}
