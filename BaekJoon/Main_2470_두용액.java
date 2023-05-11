import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_두용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);  //오름차순 정렬

        int lt = 0;
        int rt = N-1;
        int idx1=0, idx2=0;
        int min = Integer.MAX_VALUE;
        while(lt<rt) {
            int sum = arr[lt] + arr[rt];

            if(min >= Math.abs(sum)) {  //용액 특성값이 여태까지의 최소값 이하일 때의 인덱스 저장
                min = Math.min(min, Math.abs(sum));
                idx1 = lt;
                idx2 = rt;
            }

            if(sum == 0) {
                break;
            }  else if(sum > 0) {  //두 수의 합이 양수이면 인덱스 rt(큰 값)를 감소시켜줘야 특성값(절대값)이 작아짐
                rt--;
            } else if(sum < 0) {  ////두 수의 합이 음수이면 인덱스 lt(큰 값)를 증가시켜줘야 특성값(절대값)이 작아짐
                lt++;
            }
        }

        System.out.print(arr[idx1] + " " + arr[idx2]);
    }
}
