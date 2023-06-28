import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_18870_좌표압축 {  //랭킹 알고리즘 (좌표압축)
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] copy = arr.clone();  //원래 배열상태 저장할 복사배열
		Arrays.sort(arr);
		
		int rank = 0;  //낮은순 랭킹
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<N; i++) {
			if(!map.containsKey(arr[i])) {
				map.put(arr[i], rank);
				rank++;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			sb.append(map.get(copy[i])).append(" ");
		}
		
		System.out.print(sb);
	}
}
