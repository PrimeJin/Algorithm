import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_TwoPointers_1_두배열합치기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		//A배열 생성 및 초기화
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];

		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());  //배열 원소가 오름차순으로 주어짐
		}
		
		//B배열 생성 및 초기화
		int M = Integer.parseInt(br.readLine());
		int[] B = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		//two pointers 방법 이용
		int p1=0, p2=0;
		while(p1<N && p2<M) {  //값을 비교하며 두 배열 중 한 배열의 값을 다 추가할 때까지 반복
			if(A[p1] < B[p2]) {  //A[p1]값이 B[p2]보다 작으면 A[p1]값 추가하고 p1증가시킴
				sb.append(A[p1] + " ");
				p1++;
			} else if(A[p1] == B[p2]) {  //두 배열이 모두 갖고 있는 값이면 값 추가하고 p1,p2 둘다 증가시킴
				sb.append(A[p1] + " " + B[p2] + " ");
				p1++;
				p2++;
			} else {  //A[p1]값이 B[p2]보다 크면 B[p2]값을 추가하고 p2증가시킴
				sb.append(B[p2] + " ");
				p2++;
			}
		}
		//남은 원소 추가하기 
		while(p1<N) {  //A원소가 더 남았을 때 남은 A원소 추가
			sb.append(A[p1] + " ");
			p1++;
		}
		while(p2<M) {  //B원소가 더 남았을 때 남은 B원소 추가
			sb.append(B[p2] + " ");
			p2++;
		}
		
		System.out.println(sb);
	}
}
		
