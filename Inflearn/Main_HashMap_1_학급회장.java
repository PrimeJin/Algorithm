import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main_HashMap_1_학급회장 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  //반 학생수
        String vote = br.readLine();

        //기존 배열 사용 방법
//        int[] candidate = new int[5];  //후보자 득표수 배열
//        for(int i=0; i<N; i++) {
//            candidate[vote.charAt(i)-65]++;
//        }
//
//        int max=0, maxIdx=0;
//        for(int i=0; i<5; i++) {
//            if(max < candidate[i]) {
//                max = candidate[i];
//                maxIdx = i;
//            }
//        }
//        System.out.println((char)(65+maxIdx));
        
        //HashMap 사용 방법
        HashMap<Character, Integer> map = new HashMap<>();
        for(char x : vote.toCharArray()) {
        	map.put(x, map.getOrDefault(x, 0)+1);
        }
        int max = 0;
        char leader = ' ';
        for(char key : map.keySet()) {
        	if(map.get(key) > max) {
        		max = map.get(key);
        		leader = key;
        	}
        }
        System.out.println(leader);
	}
}
