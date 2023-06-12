import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_9012_괄호 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());  //테스트케이스 개수
		
		StringBuilder sb = new StringBuilder();
		for(int test_case=0; test_case<T; test_case++) {
			String answer = "YES";
			String str = br.readLine();
			Stack<Character> stack = new Stack<>();
			for(int i=0; i<str.length(); i++) {
				if(str.charAt(i) == '(') {
					stack.push('(');
				} else {
					if(stack.isEmpty()) {  // 연괄호 ( 가 없는데 )가 등장하는 경우 VPS가 아님
						answer = "NO";
						break;
					}
					stack.pop();
				}
			}
			
			if(!stack.isEmpty()) answer = "NO";  // (가 더 많아서 남아있는 경우도 VPS가 아님
			sb.append(answer).append("\n");
		}
		System.out.print(sb);
	}

}
