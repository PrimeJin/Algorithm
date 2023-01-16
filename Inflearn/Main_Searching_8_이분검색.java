import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_Searching_8_이분검색 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());  //숫자 개수
		int M = Integer.parseInt(st.nextToken());  //임의 숫자
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);  //크기순으로 정렬
		
		int lt = 0;
		int rt = N-1;
		
		int mIdx=0;  //임의의 숫자가 위치한 인덱스
		while(lt<=rt) {
			int mid = (lt+rt)/2;  //중간 인덱스
			if(arr[mid] == M) {  //현재 중간 인덱스에 위치한 값이 찾는 수이면 break
				mIdx = mid;
				break;
			}
			if(arr[mid]>M) {  //현재 중간 인덱스에 위치한 값이 찾는 수보다 크면 더 왼쪽에서 찾아야 하므로 rt=mid-1
				rt = mid-1;
			} else {  //현재 중간 인덱스에 위치한 값이 찾는 수보다 작으면 더 오른쪽에서 찾아야 하므로 lt=mid+1
				lt = mid+1;
			}
		}
		System.out.println(mIdx+1);
	}
}
