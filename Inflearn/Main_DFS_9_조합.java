import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_DFS_9_조합 {
	static int N, M;
	static boolean[] check;
	static int[] result;
//	static StringBuilder sb = new StringBuilder();
	static List<int[]> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		check = new boolean[N];
		result = new int[M];  //조합 결과 담을 배열
		dfs(0, 0);
		
		System.out.println("조합 수: " + list.size());
		for(int i=0; i<list.size(); i++) {
			System.out.println(Arrays.toString(list.get(i)));
		}
//		System.out.println(sb);
		
	}
	
	public static void dfs(int idx, int cnt) {
		if(cnt == M) {
			int[] arr = result.clone();
			list.add(arr);
//			for(int i=0; i<M; i++) {
//				sb.append(result[i]).append(" ");
//				
//			}
//			sb.append("\n");
			return;
		}
		
		for(int i=idx; i<N; i++) {
			if(!check[i]) {
				result[cnt] = i+1;
				check[i] = true;
				dfs(i, cnt+1);
				check[i] = false;
			}
		}
	}
}
