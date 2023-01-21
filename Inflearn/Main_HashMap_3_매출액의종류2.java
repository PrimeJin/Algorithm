import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_HashMap_3_매출액의종류2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());  //총 일 수
		int K = Integer.parseInt(st.nextToken());  //연속 일 수
		
		int[] nSales = new int[N];
		st = new StringTokenizer(br.readLine());
		//총 매출액 초기화
		for(int i=0; i<N; i++) {
			nSales[i] = Integer.parseInt(st.nextToken());
		}
		
//		ArrayList<Integer> result = solution(N, K, nSales);
//		//답 출력
//		StringBuilder sb = new StringBuilder();
//		for(int i=0; i<result.size(); i++) {
//			sb.append(result.get(i));
//			if(i != result.size()-1) {
//				sb.append(" ");
//			}
//		}
		
		//foreach 활용 방법
		StringBuilder sb = new StringBuilder();
		for(int x : solution(N, K, nSales)) {
			sb.append(x + " ");
		}
		
		System.out.println(sb);
	}
	
	public static ArrayList<Integer> solution(int N, int K, int[] nSales) {
		ArrayList<Integer> answer = new ArrayList<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		//Sliding window 활용
		for(int i=0; i<K-1; i++) {
			map.put(nSales[i], map.getOrDefault(nSales[i], 0)+1);
		}
		
		int lt = 0;
		for(int rt=K-1; rt<N; rt++) {
			map.put(nSales[rt], map.getOrDefault(nSales[rt], 0) + 1);  //오른쪽 끝 해당 범위 추가하고
			answer.add(map.size());  //map에 들어간 개수 = 매출액 종류
			map.put(nSales[lt], map.get(nSales[lt])-1);  //sliding window 작업
			if(map.get(nSales[lt]) == 0) {  //이때 이전 lt값이 0이 되면 제거처리 해줘야 다음에 map.size 비교시 원하는 결과 나옴
				map.remove(nSales[lt]);
			}
			lt++;
		}
		return answer;
	}
}
