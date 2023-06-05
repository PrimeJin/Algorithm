import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2309_일곱난쟁이 {
	static int[] height;
	static boolean[] check;
	static String answer;
	static int[] answerArr;
	static boolean flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		height = new int[9];
		for(int i=0; i<9; i++) {
			height[i] = Integer.parseInt(br.readLine());
		}
		
		check = new boolean[9];
		
		answerArr = new int[7];  //일곱난쟁이 키담은 배열
		flag = false;  //정답등장 여부
		comb(0, 0, 0, "");
		Arrays.sort(answerArr);
		
		for(int x : answerArr) {
			System.out.println(x);
		}
	}
	
	public static void comb(int start, int cnt, int sum, String appear) {
		if(flag) return;  //답 나온 이상 더이상 비교 필요없음
		
		if(cnt == 7) {
			if(sum == 100) {
				for(int i=0; i<appear.length(); i++) {
					answerArr[i] = height[appear.charAt(i) - '0'];
				}
				flag = true;
			}
			return;
		}
		
		for(int i=start; i<9; i++) {
			if(!check[i]) {
				check[i] = true;
				comb(i, cnt+1, sum + height[i], appear + i);
				check[i] = false;
			}
		}
	}
}
