package day0103;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_Array_11_임시반장정하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int num = Integer.parseInt(br.readLine());  //반 학생 수
		int[][] memo = new int[num][5];
		//입력처리
		for(int i=0; i<num; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++) {
				memo[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean[][] check = new boolean[num][num];
		//같은 반 비교
		for(int i=0; i<5; i++) {
			for(int j=0; j<num; j++) {
				for(int k=0; k<num; k++) {
					if(j!=k && memo[j][i] == memo[k][i]) {
						check[j][k] = true;
					}
				}
			}
		}
		
		int max = 0;
		int leader = 0;
		for(int i=0; i<num; i++) {
			int count = 0;
			for(int j=0; j<num; j++) {
				if(check[i][j]) {
					count++;
				}
			}
			if(max<count) {
				max = count;
				leader = i;
			}
		}
		
		System.out.println(leader+1);  //0번 인덱스 = 1번학생
		
		
		
	}
}
