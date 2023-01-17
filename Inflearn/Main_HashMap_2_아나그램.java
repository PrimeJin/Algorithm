import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main_HashMap_2_아나그램 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String word1 = br.readLine();
		String word2 = br.readLine();
		
		//첫 풀이 방법
//		HashMap<Character, Integer> map = new HashMap<>();
		//첫번째 문자열 알파벳 등장횟수 map으로 누적 저장
//		for(char x : word1.toCharArray()) {
//			map.put(x, map.getOrDefault(x, 0)+1);
//		}
//		
//		//두번째 문자열 알파벳 등장횟수 map에서 차감
//		for(char x : word2.toCharArray()) {
//			map.put(x, map.getOrDefault(x, 0)-1);
//		}
//		
//		int count = 0;
//		for(char x : map.keySet()) {
//			if(map.get(x) != 0) {  //하나라도 남은 알파벳이 있으면 아나그램 X
//				count++;
//			}
//		}
//		
//		if(count == 0) {
//			System.out.println("YES");
//		} else {
//			System.out.println("NO");
//		}
		
		//강의 활용 풀이방법
		System.out.println(solution(word1, word2));
	}
	//강의 활용 풀이방법
	public static String solution(String str1, String str2) {
		String answer = "YES";
		
		HashMap<Character, Integer> map = new HashMap<>();
		for(char x : str1.toCharArray()) {
			map.put(x, map.getOrDefault(x, 0)+1);
		}
		for(char x : str2.toCharArray()) {
			if(!map.containsKey(x) || map.get(x)==0) {  //다른 알파벳을 갖고 있거나 알파벳 개수가 안맞는 경우 아나그램 X
				answer = "NO";
				break;
			}
			map.put(x, map.get(x)-1);  //map에서 알파벳 개수값 1감소
		}
		
		return answer;
	}
	
}
