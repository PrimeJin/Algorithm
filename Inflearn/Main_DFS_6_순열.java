import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_DFS_6_순열 {
	static int N, M;
	static int[] result;
	static boolean[] check;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		//N개의 자연수 중 M개 뽑기
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		result = new int[M];  //순열 저장할 배열
		check = new boolean[N];  //방문 체크할 배열
		permutation(0);
		
		System.out.println(sb);
	}
	
	public static void permutation(int cnt) {
		if(cnt == M) {
			for(int i=0; i<M; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!check[i]) {
				check[i] = true;
				result[cnt] = i+1;
				permutation(cnt+1);
				check[i] = false;
			}
		}
	}
}
