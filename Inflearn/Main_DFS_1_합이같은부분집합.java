import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_DFS_1_합이같은부분집합 {
	static int N;  //배열 크기
	static boolean[] check;  //포함여부 확인배열
	static String answer;  //정답 문자열
	static boolean flag = false;  //이미 답이 YES인지 확인
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());  //원소 개수
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		check = new boolean[N];  //부분집합 포함여부 (true인 애들이랑 false인 애들비교)
		answer = "NO";
		powerSet(0, arr);
		
		System.out.println(answer);
	}
	
	public static void powerSet(int idx, int[] arr) {
		if(idx == N) {
			if(flag) return;  //이미 답이 YES로 나왔으면 바로 return
			int sum1 = 0, sum2 = 0;
			for(int i=0; i<N; i++) {
				if(check[i]) {
					sum1 += arr[i];
//					System.out.print(arr[i] + " ");
				} else {
					sum2 += arr[i];
				}
				
				if(sum1 == sum2) {
					answer = "YES";
					flag = true;
				}
			}
//			System.out.println();
			return;
		}
		
		check[idx] = true;
		powerSet(idx+1, arr);
		check[idx] = false;
		powerSet(idx+1, arr);
		
		
	}
}
