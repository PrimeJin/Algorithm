import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_TwoPointers_2_공통원소구하기 {
	public static void main(String[] arsg) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());  //집합 A 크기
		st = new StringTokenizer(br.readLine());
		
		int[] A = new int[N];
		//집합 A 원소 초기화
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());  //집합 B 크기
		st = new StringTokenizer(br.readLine());
		
		int[] B = new int[M];
		//집합 B 원소 초기화
		for(int i=0; i<M; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(A);
		Arrays.sort(B);
		
		//공통원소 찾기 (two pointers 알고리즘 사용)
		int p1=0, p2=0;
		while(p1<N && p2<M) {
			if(A[p1] == B[p2]) {
				sb.append(A[p1] + " ");
				p1++;
				p2++;
			} else if(A[p1] < B[p2]) {  //A[p1]이 B[p2]보다 작으면 더이상 B에는 A[p1] 값을 가진 원소가 없으므로 p1증가
				p1++;
			} else {  //A[p1]이 B[p2]보다 큰 경우 (더 큰 B의 원소를 찾기 위해 p2증가)
				p2++;
			}
		}
		
		System.out.println(sb);
		
	}
}
