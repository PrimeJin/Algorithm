import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2309_일곱난쟁이_simple {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] height = new int[9];
		
		int total = 0;
		for(int i=0; i<9; i++) {
			height[i] = Integer.parseInt(br.readLine());
			total += height[i];
		}
		
		
		//9명의 총 합에서 임의의 두명값을 뺐을 때 100이면 남은 7명이 일곱난쟁이임
		label1: for(int i=0; i<9; i++) {
			for(int j=i+1; j<9; j++) {
				if(total - (height[i] + height[j]) == 100) {
					height[i] = -1;  //키는 자연수이므로 가짜애들은 -1로 바꿔줌
					height[j] = -1;
					break label1;  //반복문 전부 종료
				}
			}
		}
		
		Arrays.sort(height);
		StringBuilder sb = new StringBuilder();
		for(int i=2; i<9; i++) {
			sb.append(height[i]).append("\n");
		}
		
		System.out.print(sb);
	}
}
