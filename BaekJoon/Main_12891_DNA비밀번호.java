import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12891_DNA비밀번호 {
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		answer = 0;
		st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		String str = br.readLine();  //DNA 문자
		
		st = new StringTokenizer(br.readLine());
		int[] cntArr = new int[4];
		
		for(int i=0; i<4; i++) {
			cntArr[i] = Integer.parseInt(st.nextToken());
		}
		
		char[] chArr = str.toCharArray();
		for(int i=0; i<P; i++) {
			nextCheck(i, chArr, cntArr);
		}
		plusCnt(cntArr);  //처음 범위에 해당하는 결과가 DNA 문자열인지 비교 
		
		for(int i=P; i<S; i++) {
			preCheck(i-P, chArr, cntArr);
			nextCheck(i, chArr, cntArr);
			plusCnt(cntArr);
		}
		System.out.println(answer);
	}
	
	public static void nextCheck(int idx, char[] chArr, int[] cntArr) {  //다음 인덱스에 해당하는 문자 최소 등장횟수 -1시키기(등장했으므로)
		if(chArr[idx] == 'A') {
			cntArr[0]--;
		} else if(chArr[idx] == 'C') {
			cntArr[1]--;
		} else if(chArr[idx] == 'G') {
			cntArr[2]--;
		} else if(chArr[idx] == 'T') {
			cntArr[3]--;
		}
	}
	
	public static void preCheck(int idx, char[] chArr, int[] cntArr) {  //맨이전 인덱스에 해당하는 값은 다시 최소 등장횟수 +1시켜서 복구시키기
		if(chArr[idx] == 'A') {
			cntArr[0]++;
		} else if(chArr[idx] == 'C') {
			cntArr[1]++;
		} else if(chArr[idx] == 'G') {
			cntArr[2]++;
		} else if(chArr[idx] == 'T') {
			cntArr[3]++;
		}
	}
	
	public static void plusCnt(int[] cntArr) {  //최소등장 횟수 만족하면 정답(cnt)개수 증가시키기
		boolean flag = false;
		for(int i=0; i<4; i++) {
			if(cntArr[i] > 0) {
				flag = true;
				break;
			}
		}
		
		if(!flag) {
			answer++;
		}
	}
}
