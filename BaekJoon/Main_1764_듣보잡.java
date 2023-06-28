import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_1764_듣보잡 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		//듣도 못한 사람
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			map.put(str, map.getOrDefault(str, 0) + 1);
		}
		
		//보도 못한 사람
		ArrayList<String> list = new ArrayList<>();
		for(int i=0; i<M; i++) {
			String str = br.readLine();
			if(map.containsKey(str)) {  //보도 못한 사람이 듣도 못한 사람 중에 있는 사람인지 체크
				list.add(str);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(list.size()).append("\n");
		Collections.sort(list);  //사전순 정렬
		for(int i=0; i<list.size(); i++) {
			sb.append(list.get(i)).append("\n");
		}
		
		System.out.print(sb);
	}
}
