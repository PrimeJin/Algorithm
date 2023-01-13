import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_HashMap_1_학급회장 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  //반 학생수
        String vote = br.readLine();
        int len=vote.length();

        int[] candidate = new int[5];  //후보자 득표수 배열
        for(int i=0; i<len; i++) {
            candidate[vote.charAt(i)-65]++;
        }

        // HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        // map.put('A', ca
        int max=0, maxIdx=0;
        for(int i=0; i<5; i++) {
            if(max < candidate[i]) {
                max = candidate[i];
                maxIdx = i;
            }
        }
        System.out.println((char)(65+maxIdx));
	}
}
