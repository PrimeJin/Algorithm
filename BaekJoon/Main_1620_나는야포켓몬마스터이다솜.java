import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_1620_나는야포켓몬마스터이다솜 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());  //포켓몬 개수
		int M = Integer.parseInt(st.nextToken());  //맞춰야되는 문제 개수
		
		Map<String, Integer> mapStoI = new HashMap<>();
		Map<Integer, String> mapItoS = new HashMap<>();
		
		for(int i=1; i<=N; i++) {
			String str = br.readLine();
			mapItoS.put(i, str);
			mapStoI.put(str, i);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			String str = br.readLine();
			char ch = str.charAt(0);
			if('0' <= ch&&ch <= '9') {  //포켓몬 번호
				sb.append(mapItoS.get(Integer.parseInt(str))).append("\n");
			} else {  //포켓몬 이름일 때
				sb.append(mapStoI.get(str)).append("\n");
			}
		}
		
		System.out.print(sb);
	}
}
