import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_String_12_암호 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());  //보낸 문자의 개수
		String str = br.readLine();  //신호
		int cnt = 0;
		StringBuilder tmp = new StringBuilder();  //일곱자리 신호의 이진수 결과를 저장할 StringBuilder
		StringBuilder answer = new StringBuilder();  //정답 문자열 (비밀편지 메일내용)
		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			
			if(ch == '#') {
				tmp.append(1);
			} else if(ch == '*') {
				tmp.append(0);
			}
			
			cnt++;
			if(cnt == 7) {
				int tempN = 0;  //제곱수
				int asciiNum = 0;  //아스키 변환값
				for(int j=6; j>=0; j--) {
					if(tmp.charAt(j) == '1') {
						asciiNum += Math.pow(2, tempN);
					}
					tempN++;
				}
				tmp = new StringBuilder();
				cnt = 0;
				
				answer.append((char)asciiNum);
			}
		}
		
		System.out.println(answer);
	}
}
